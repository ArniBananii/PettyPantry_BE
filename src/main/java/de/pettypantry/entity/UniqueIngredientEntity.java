package de.pettypantry.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "UNIQUEINGREDIENT")
@Entity(name = "UNIQUEINGREDIENT")
public class UniqueIngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uniqueIngredientId;

    @ManyToOne
    @JoinColumn(name = "pantryid", referencedColumnName = "pantryId", nullable = false)
    private PantryEntity pantry;

    @ManyToOne
    @JoinColumn(name = "ingredientid", referencedColumnName = "ingredientId", nullable = false)
    private IngredientEntity ingredient;

    @Column(name = "expDate", nullable = false)
    private LocalDate expirationDate;

    public UniqueIngredientEntity(PantryEntity pantry, IngredientEntity ingredient, LocalDate expirationDate) {
        this.pantry = pantry;
        this.ingredient = ingredient;
        this.expirationDate = expirationDate;
    }

    protected UniqueIngredientEntity() {
    }

    public int getUniqueIngredientId() {
        return uniqueIngredientId;
    }

    public PantryEntity getPantry() {
        return pantry;
    }

    public IngredientEntity getIngredient() {
        return ingredient;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
