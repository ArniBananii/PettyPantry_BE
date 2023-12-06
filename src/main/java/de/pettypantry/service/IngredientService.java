package de.pettypantry.service;

import de.pettypantry.entity.IngredientEntity;
import de.pettypantry.entity.IngredientRepository;
import de.pettypantry.web.api.Ingredient;
import de.pettypantry.web.models.IngredientModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IngredientService {

    private IngredientRepository ingredientRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAll() {
        List<IngredientEntity> ingredientEntities = ingredientRepository.findAll();
        List<Ingredient> ingredients = ingredientEntities.stream().map(this::transformEntity).toList();
        logger.info("Ingredients found: " + ingredients.size());
        return ingredients;
    }

    public Ingredient findById(int ingredientId) {
        var ingredientEntity = ingredientRepository.findById(ingredientId);
        return ingredientEntity.map(this::transformEntity).orElse(null);
    }

    public IngredientEntity findIngredientEntityById(int ingredientId) {
        var ingredientEntityOptional = ingredientRepository.findById(ingredientId);
        return ingredientEntityOptional.orElse(null);
    }

    public Ingredient create(IngredientModel request) {
        var ingredientEntity = new IngredientEntity(request.getIngredientName(), request.getValidNoOfDays());
        ingredientEntity = ingredientRepository.save(ingredientEntity);
        return transformEntity(ingredientEntity);
    }

    public Ingredient update(int id, IngredientModel request) {
        var ingredientEntityOptional = ingredientRepository.findById(id);
        if (ingredientEntityOptional.isEmpty()) {
            return null;
        }
        var ingredientEntity = ingredientEntityOptional.get();
        ingredientEntity.setIngredientName(request.getIngredientName());
        ingredientEntity.setValidNoOfDays(request.getValidNoOfDays());
        ingredientEntity = ingredientRepository.save(ingredientEntity);
        return transformEntity(ingredientEntity);
    }

    public Ingredient transformEntity(IngredientEntity ingredientEntity) {
        return new Ingredient(ingredientEntity.getIngredientId(),
                ingredientEntity.getIngredientName(),
                ingredientEntity.getValidNoOfDays());
    }
}
