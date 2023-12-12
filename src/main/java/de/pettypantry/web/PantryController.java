package de.pettypantry.web;


import de.pettypantry.service.PantryService;
import de.pettypantry.service.UserService;
import de.pettypantry.web.api.Pantry;
import de.pettypantry.web.models.PantryModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/api/v1/pantry/{userid}")
    public ResponseEntity<Pantry> fetchPantryByUserId(@PathVariable int userid) {
        var user = userService.findUserEntityByID(userid);
        var pantry = pantryService.findById(user.getUserPantry().getPantryId());
        return pantry != null ? ResponseEntity.ok(pantry) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/pantry")
    public ResponseEntity<Void> createPantry(@RequestBody PantryModel request) throws URISyntaxException {
        var user = userService.findUserEntityByID(request.getUserid());
        var pantry = pantryService.create(user);
        URI uri = new URI("/api/v1/pantry/" + pantry.getPantryID());
        return ResponseEntity.created(uri).build();
    }
}
