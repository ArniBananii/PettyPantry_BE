package de.pettypantry.web;

import de.pettypantry.service.IngredientService;
import de.pettypantry.service.PantryService;
import de.pettypantry.service.UniqueIngredientService;
import de.pettypantry.service.UserService;
import de.pettypantry.web.api.Pantry;
import de.pettypantry.web.api.UniqueIngredient;
import de.pettypantry.web.models.UniqueIngredientModel;
import de.pettypantry.web.models.UnqDeleteBody;
import de.pettypantry.web.models.UnqDeleteSingleModelTest;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UniqeIngredientController {

    private final UniqueIngredientService uniqueIngredientService;
    private final IngredientService ingredientService;
    private final PantryService pantryService;
    private final UserService userService;

    public UniqeIngredientController(UniqueIngredientService uniqueIngredientService, IngredientService ingredientService, PantryService pantryService, UserService userService) {
        this.uniqueIngredientService = uniqueIngredientService;
        this.ingredientService = ingredientService;
        this.pantryService = pantryService;
        this.userService = userService;
    }

    @GetMapping(path = "/api/v1/unqingredients")
    public ResponseEntity<List<UniqueIngredient>> fetchUniqueIngredients() {
        return ResponseEntity.status(201).body(uniqueIngredientService.findAll());
    }

    @DeleteMapping(path = "/api/v1/unqingredients")
    public ResponseEntity<Void> deleteUniqueIngredient(@RequestBody UnqDeleteBody request) {
        int[] unqIngIds = request.getUnqIngIDs();
        boolean successful = true;
        for(int id : unqIngIds) {
            successful = uniqueIngredientService.deleteById(id);
            if(!successful) {
                break;
            }
        }
        //TODO: Where is successful set to false?
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/unqingredient/{unqIngID}")
    public ResponseEntity<Void> deleteUniqueIngredient(@PathVariable int unqIngID) {
        boolean successful = uniqueIngredientService.deleteById(unqIngID);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/api/v1/unqingredients/pantry/{pantryID}")
    public ResponseEntity<List<UniqueIngredient>> fetchUnqIngredientByPantryID(@PathVariable int pantryID) {
        List<UniqueIngredient> uniqueIngredients = fetchUniqueIngredients().getBody();
        Pantry pantry = pantryService.findById(pantryID);
        if (uniqueIngredients == null || pantry == null) {
            return ResponseEntity.notFound().build();
        }
        uniqueIngredients = uniqueIngredients.stream().filter(value -> value.getPantryID() == pantryID).collect(Collectors.toList());
        return ResponseEntity.status(201).body(uniqueIngredients);
    }

    @GetMapping(path = "/api/v1/unqingredients/user/{userID}")
    public ResponseEntity<List<UniqueIngredient>> fetchUnqIngredientByUserID(@PathVariable int userID) {
        var user = userService.findUserEntityByID(userID);
        if(user == null || user.getUserPantry() == null) {
            return ResponseEntity.notFound().build();
        }
        int pantryID = user.getUserPantry().getPantryId();
        return fetchUnqIngredientByPantryID(pantryID);
    }

    @Transactional
    @PostMapping(path = "/api/v1/unqingredient")
    public ResponseEntity<Void> createUniqueIngredient(@RequestBody UniqueIngredientModel request) throws URISyntaxException {
        var ingredientEntity = ingredientService.findIngredientEntityById(request.getIngredientId());
        var pantryEntity = pantryService.findPantryEntityByID(request.getPantryId());
        if(ingredientEntity == null || pantryEntity == null) {
            return ResponseEntity.notFound().build();
        }
        var uniqueIngredient = uniqueIngredientService.create(pantryEntity, ingredientEntity);
        URI uri = new URI("/api/v1/unqingredient/" + uniqueIngredient.getUniqueIngredientID());
        return ResponseEntity.created(uri).build();
    }
}
