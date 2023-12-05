package de.pettypantry.web;

import de.pettypantry.service.IngredientService;
import de.pettypantry.web.api.Ingredient;
import de.pettypantry.web.models.IngredientModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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

    @PostMapping(path = "/api/v1/ingredient")
    public ResponseEntity<Void> createIngredient(@RequestBody IngredientModel request) throws URISyntaxException {
        var ingredient = ingredientService.create(request);
        URI uri = new URI("api/v1/ingredient/" + ingredient.getIngredientId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/ingredient/{ingredientId}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable int ingredientId, @RequestBody IngredientModel request) {
        var ingredient = ingredientService.update(ingredientId, request);
        return ingredient != null ? ResponseEntity.ok(ingredient) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/ingredient/{ingredientId}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int ingredientId) {

        boolean succesful = ingredientService.deleteById(ingredientId);
        return succesful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
