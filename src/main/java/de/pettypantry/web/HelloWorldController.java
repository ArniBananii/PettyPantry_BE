package de.pettypantry.web;

import de.pettypantry.entity.PersonsReposetory;
import de.pettypantry.service.PersonsService;
import de.pettypantry.web.api.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HelloWorldController {


private final PersonsService personsService;

    public HelloWorldController(PersonsService personsService) {
        this.personsService = personsService;
    }


    @GetMapping("/")
    public ModelAndView helloWorld() {
        return new ModelAndView("helloWorld");
    }

    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity<List<Persons>> fetchPersons(){
        return ResponseEntity.status(201).body(personsService.findAll());
    }

}

