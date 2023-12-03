package de.pettypantry.service;

import de.pettypantry.entity.PantryEntity;
import de.pettypantry.entity.PantryRepository;
import de.pettypantry.entity.UserEntity;
import de.pettypantry.web.api.Pantry;
import de.pettypantry.web.api.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PantryService {

    private final PantryRepository pantryRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public PantryService(PantryRepository pantryRepository) {
        this.pantryRepository = pantryRepository;
    }

    public List<Pantry> findAll() {
        List<PantryEntity> pantries = pantryRepository.findAll();
        List<Pantry> pantryList = pantries.stream().map(this::transformEntity).toList();
        logger.info("Pantries found: " + pantryList.size());
        return pantryList;
    }

    public void deleteById(int id) {
        pantryRepository.deleteById(id);
    }

    public Pantry findById(int id) {
        var PantryEntity = pantryRepository.findById(id);
        return PantryEntity.map(this::transformEntity).orElse(null);
    }

    public void save(PantryEntity pantry) {
        pantryRepository.save(pantry);
    }

    public PantryEntity findPantryEntityByID(int id) {
        var pantryEntityOptional = pantryRepository.findById(id);
        return pantryEntityOptional.orElse(null);
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
