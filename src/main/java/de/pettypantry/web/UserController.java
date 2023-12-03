package de.pettypantry.web;

import de.pettypantry.service.UserService;
import de.pettypantry.web.models.UserModel;
import de.pettypantry.web.api.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {


private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/api/v1/users")
    public ResponseEntity<List<User>> fetchUsers(){
        return ResponseEntity.status(201).body(userService.findAll());
    }

    @GetMapping(path = "/api/v1/user/{userID}")
    public ResponseEntity<User> fetchUserById(@PathVariable int userID) {
        var user = userService.findByID(userID);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/user")
    public ResponseEntity<Void> createUser(@RequestBody UserModel request) throws URISyntaxException {
        var user = userService.create(request);
        URI uri = new URI("/api/v1/user/" + user.getUserid());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/users/{userID}")
    public ResponseEntity<User> updateUser(@PathVariable int userID, @RequestBody UserModel request) {
        var user = userService.update(userID, request);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/users/{userID}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userID) {
        boolean successful = userService.deleteById(userID);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

