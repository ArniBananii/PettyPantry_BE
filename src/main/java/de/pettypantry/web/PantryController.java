package de.pettypantry.web;


import de.pettypantry.service.PantryService;
import de.pettypantry.service.UserService;
import de.pettypantry.web.api.Pantry;
import de.pettypantry.web.models.PantryModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PantryController {

    private final UserService userService;
    private final PantryService pantryService;

    public PantryController(UserService userService, PantryService pantryService) {
        this.userService = userService;
        this.pantryService = pantryService;
    }

    @GetMapping(path = "/api/v1/pantries")
    public ResponseEntity<List<Pantry>> fetchPantries() {
        return ResponseEntity.status(201).body(pantryService.findAll());
    }

    @PostMapping(path = "/api/v1/pantry")
    public ResponseEntity<Void> createPantry(@RequestBody PantryModel request) throws URISyntaxException {
        var user = userService.findUserEntityByID(request.getUserid());
        var pantry = pantryService.create(user);
        URI uri = new URI("/api/v1/pantry/" + pantry.getPantryid());
        return ResponseEntity.created(uri).build();
    }
}
