package de.pettypantry.service;

import de.pettypantry.entity.PersonsEntity;
import de.pettypantry.entity.PersonsReposetory;
import de.pettypantry.web.models.PersonModel;
import de.pettypantry.web.api.Persons;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import java.util.stream.Collectors;

@Service
public class PersonsService {
    private final PersonsReposetory personsReposetory;
    Logger logger = LoggerFactory.getLogger(PersonsService.class);
    public PersonsService(PersonsReposetory personsReposetory) {
        this.personsReposetory = personsReposetory;
    }

    public List<Persons> findAll() {
        List<PersonsEntity> persons = personsReposetory.findAll();

        List<Persons> personsList = persons.stream().map(this::transformEntity).collect(Collectors.toList());
        logger.info("Persons found: " + personsList.size());
        return personsList;
    }

    public Persons findByID(int id) {
        var personEntity = personsReposetory.findById(id);
        return personEntity.map(this::transformEntity).orElse(null);
    }

    public Persons create(PersonModel request) {
        var personEntity = new PersonsEntity(request.getFirstName(), request.getLastName(), request.getAddress(), request.getCity());
        personEntity = personsReposetory.save(personEntity);
        return transformEntity(personEntity);
    }

    public Persons update(int id, PersonModel model) {
        var personsEntityOptional = personsReposetory.findById(id);
        if (personsEntityOptional.isEmpty()) {
            return null;
        }
        var personsEntity = personsEntityOptional.get();
        personsEntity.setFirstName(model.getFirstName());
        personsEntity.setLastName(model.getLastName());
        personsEntity.setAddress(model.getAddress());
        personsEntity.setCity(model.getCity());
        personsEntity = personsReposetory.save(personsEntity);
        return transformEntity(personsEntity);
    }

    private Persons transformEntity(PersonsEntity personsEntity) {
        return new Persons(personsEntity.getPersonId(),
                personsEntity.getFirstName(),
                personsEntity.getLastName(),
                personsEntity.getAddress(),
                personsEntity.getCity()
        );
    }
}
