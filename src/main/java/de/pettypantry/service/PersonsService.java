package de.pettypantry.service;

import de.pettypantry.entity.PersonsEntity;
import de.pettypantry.entity.PersonsReposetory;
import de.pettypantry.web.api.PersonCreateRequest;
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

    public Persons create(PersonCreateRequest request) {
        var personEntity = new PersonsEntity(request.getFirstName(), request.getLastName(), request.getAddress(), request.getCity());
        personEntity = personsReposetory.save(personEntity);
        return transformEntity(personEntity);
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
