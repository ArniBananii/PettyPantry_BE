package de.pettypantry.service;

import de.pettypantry.entity.UniqueIngredientEntity;
import de.pettypantry.entity.UniqueIngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UniqueIngredientService {

    private final UniqueIngredientRepository uniqueIngredientRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UniqueIngredientService(UniqueIngredientRepository uniqueIngredientRepository) {
        this.uniqueIngredientRepository = uniqueIngredientRepository;
    }
    public void save(UniqueIngredientEntity uniqueIngredientEntity) {
        uniqueIngredientRepository.save(uniqueIngredientEntity);
    }
}
