package de.pettypantry.web;

import de.pettypantry.entity.PantryEntity;
import de.pettypantry.entity.UniqueIngredientEntity;
import de.pettypantry.service.PantryService;
import de.pettypantry.service.UniqueIngredientService;
import de.pettypantry.service.UserService;
import de.pettypantry.web.models.UserModel;
import de.pettypantry.web.api.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {


private final UserService userService;
private final PantryService pantryService;
private final UniqueIngredientService uniqueIngredientService;

    public UserController(UserService userService, PantryService pantryService, UniqueIngredientService uniqueIngredientService) {
        this.userService = userService;
        this.pantryService = pantryService;
        this.uniqueIngredientService = uniqueIngredientService;
    }

    @GetMapping(path = "/api/v1/users")
    public ResponseEntity<List<User>> fetchUsers(){
        return ResponseEntity.status(201).body(userService.findAll());
    }

    @GetMapping(path = "/api/v1/user/{userName}")
    public ResponseEntity<User> fetchUserById(@PathVariable String userName) {
        var user = userService.findByUserName(userName);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/user")
    public ResponseEntity<User> fetchUserByNamePassword(@RequestBody UserModel request) {
        var user = userService.findByUserName(request.getUserName());
        var userEntity = userService.findEntityByUserName(request.getUserName());
        request.setPassword(String.valueOf(request.getPassword().hashCode()));
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if (userEntity.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(401).build();
    }

    @PostMapping(path = "/api/v1/register")
    public ResponseEntity<Void> createUser(@RequestBody UserModel request) throws URISyntaxException {
        var userCheck = userService.findByUserName(request.getUserName());
        if (userCheck != null) {
            return ResponseEntity.status(409).build();
        }
        request.setPassword(String.valueOf(request.getPassword().hashCode()));
        var user = userService.create(request);
        pantryService.create(userService.findUserEntityByID(user.getUserID()));
        URI uri = new URI("/api/v1/user/" + user.getUserID());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/user/{userID}")
    public ResponseEntity<User> updateUser(@PathVariable int userID, @RequestBody UserModel request) {
        var user = userService.update(userID, request);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/user/{userID}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userID) {
        var user = userService.findUserEntityByID(userID);
        boolean successful;
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        PantryEntity pantry = user.getUserPantry();
        Set<UniqueIngredientEntity> uniqueIngredientEntities = pantry.getIngredients();
        if (!uniqueIngredientEntities.isEmpty()) {
            for (UniqueIngredientEntity value : uniqueIngredientEntities) {
                uniqueIngredientService.deleteById(value.getUniqueIngredientId());
            }
        }
        pantryService.deleteById(pantry.getPantryId());
        successful = userService.deleteById(user.getUserId());
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

