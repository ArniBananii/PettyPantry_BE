package de.pettypantry.web;

import de.pettypantry.service.PersonsService;
import de.pettypantry.web.models.PersonModel;
import de.pettypantry.web.api.Persons;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PantryController {


private final PersonsService personsService;

    public PantryController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity<List<Persons>> fetchPersons(){
        return ResponseEntity.status(201).body(personsService.findAll());
    }

    @GetMapping(path = "/api/v1/persons/{personID}")
    public ResponseEntity<Persons> fetchPersonById(@PathVariable int personID) {
        var person = personsService.findByID(personID);
        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/persons")
    public ResponseEntity<Void> createPerson(@RequestBody PersonModel request) throws URISyntaxException {
        var person = personsService.create(request);
        URI uri = new URI("/api/v1/persons/" + person.getPersonId());
        return ResponseEntity.created(uri).build();
    }
}

