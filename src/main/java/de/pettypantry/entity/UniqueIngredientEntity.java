package de.pettypantry.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "UNIQUEINGREDIENT")
@Entity(name = "UNIQUEINGREDIENT")
public class UniqueIngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uniqueIngredientId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pantryid", referencedColumnName = "pantryId")
    private Pantry pantry;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredientid", referencedColumnName = "ingredientId")
    private IngredientEntity ingredient;

    @Column(name = "expDate", nullable = false)
    private LocalDate expirationDate;
}
