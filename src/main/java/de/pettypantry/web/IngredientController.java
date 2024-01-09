package de.pettypantry.web;

import de.pettypantry.entity.UniqueIngredientEntity;
import de.pettypantry.service.IngredientService;
import de.pettypantry.service.UniqueIngredientService;
import de.pettypantry.web.api.Ingredient;
import de.pettypantry.web.models.IngredientModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(path = "/api/v1/ingredients")
    public ResponseEntity<List<Ingredient>> fetchIngredients() {
        return ResponseEntity.status(201).body(ingredientService.findAll());
    }

    @GetMapping(path = "/api/v1/ingredient/{ingredientId}")
    public ResponseEntity<Ingredient> findById(@PathVariable int ingredientId) {
        var ingredient = ingredientService.findById(ingredientId);
        return ingredient != null ? ResponseEntity.ok(ingredient) : ResponseEntity.notFound().build();
    }
}
