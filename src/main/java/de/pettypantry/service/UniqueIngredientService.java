package de.pettypantry.service;

import de.pettypantry.entity.*;
import de.pettypantry.web.api.UniqueIngredient;
import de.pettypantry.web.models.PantryModel;
import de.pettypantry.web.models.UniqueIngredientModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UniqueIngredientService {

    private final UniqueIngredientRepository uniqueIngredientRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UniqueIngredientService(UniqueIngredientRepository uniqueIngredientRepository) {
        this.uniqueIngredientRepository = uniqueIngredientRepository;
    }

    public List<UniqueIngredient> findAll() {
        List<UniqueIngredientEntity> uniqueIngredientEntities = uniqueIngredientRepository.findAll();
        List<UniqueIngredient> uniqueIngredients = uniqueIngredientEntities.stream().map(this::transformEntity).toList();
        logger.info("UniqueIngredients found: " + uniqueIngredients.size());
        return uniqueIngredients;
    }

    public UniqueIngredient create(PantryEntity pantry, IngredientEntity ingredient) {
        LocalDate expDate = LocalDate.now().plusDays(ingredient.getValidNoOfDays());
        var uniqueIngredientEntity = new UniqueIngredientEntity(pantry, ingredient, expDate);
        uniqueIngredientEntity = uniqueIngredientRepository.save(uniqueIngredientEntity);
        return transformEntity(uniqueIngredientEntity);
    }

    public void save(UniqueIngredientEntity uniqueIngredientEntity) {
        uniqueIngredientRepository.save(uniqueIngredientEntity);
    }

    public boolean deleteById(int id) {
        if (!uniqueIngredientRepository.existsById(id)) {
            return false;
        }
        uniqueIngredientRepository.deleteById(id);
        return true;
    }

    public UniqueIngredient transformEntity(UniqueIngredientEntity uniqueIngredientEntity) {
        return new UniqueIngredient(uniqueIngredientEntity.getUniqueIngredientId(),
                uniqueIngredientEntity.getPantry().getPantryId(),
                uniqueIngredientEntity.getIngredient().getIngredientId(),
                uniqueIngredientEntity.getExpirationDate());
    }
}
