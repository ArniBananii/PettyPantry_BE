package de.pettypantry.entity;

import de.pettypantry.web.api.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "PANTRY")
@Table(name = "PANTRY")
public class Pantry {

    @EmbeddedId
    private PantryId pantryId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    IngredientEntity ingredient;
}
