package de.pettypantry.web;

import de.pettypantry.service.IngredientService;
import de.pettypantry.service.PantryService;
import de.pettypantry.service.UniqueIngredientService;
import de.pettypantry.service.UserService;
import de.pettypantry.web.api.UniqueIngredient;
import de.pettypantry.web.models.UniqueIngredientModel;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UniqeIngredientController {

    private final UniqueIngredientService uniqueIngredientService;
    private final IngredientService ingredientService;
    private final PantryService pantryService;

    public UniqeIngredientController(UniqueIngredientService uniqueIngredientService, IngredientService ingredientService, PantryService pantryService) {
        this.uniqueIngredientService = uniqueIngredientService;
        this.ingredientService = ingredientService;
        this.pantryService = pantryService;
    }

    @GetMapping(path = "/api/v1/unqingredients")
    public ResponseEntity<List<UniqueIngredient>> fetchUniqueIngredients() {
        return ResponseEntity.status(201).body(uniqueIngredientService.findAll());
    }

    @Transactional
    @PostMapping(path = "/api/v1/unqingredient")
    public ResponseEntity<Void> createUniqueIngredient(@RequestBody UniqueIngredientModel request) throws URISyntaxException {
        var ingredientEntity = ingredientService.findIngredientEntityById(request.getIngredientId());
        var pantryEntity = pantryService.findPantryEntityByID(request.getPantryId());
        var uniqueIngredient = uniqueIngredientService.create(pantryEntity, ingredientEntity, request);
        URI uri = new URI("/api/v1/unqingredient/" + uniqueIngredient.getUniqueIngredientId());
        return ResponseEntity.created(uri).build();
    }
}
