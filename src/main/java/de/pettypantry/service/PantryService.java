package de.pettypantry.service;

import de.pettypantry.entity.PantryEntity;
import de.pettypantry.entity.PantryRepository;
import de.pettypantry.entity.UserEntity;
import de.pettypantry.web.api.Pantry;
import de.pettypantry.web.api.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PantryService {

    private final PantryRepository pantryRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public PantryService(PantryRepository pantryRepository) {
        this.pantryRepository = pantryRepository;
    }

    public Pantry create(UserEntity user) {
        var pantryEntity = new PantryEntity(user);
        pantryEntity = pantryRepository.save(pantryEntity);
        var pantry = transformEntity(pantryEntity);
        return pantry;

    }

    public Pantry transformEntity(PantryEntity pantry) {
        return new Pantry(pantry.getPantryId(),
                pantry.getOwnerUser().getUserId());
    }
}
