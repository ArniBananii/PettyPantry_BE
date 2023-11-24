package de.pettypantry.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Table(name = "INGREDIENT")
@Entity(name = "INGREDIENT")
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;

    @Column(name = "name", nullable = false)
    private String ingredientName;

    @Column(name = "validNoOfDays")
    private int validNoOfDays;

    public IngredientEntity(String ingredientName, int validNoOfDays) {
        this.ingredientName = ingredientName;
        this.validNoOfDays = validNoOfDays;
    }

    @OneToMany(mappedBy = "ingredient")
    private Set<Pantry> ingredientPantries;

    protected IngredientEntity() {
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getValidNoOfDays() {
        return validNoOfDays;
    }

    public void setValidNoOfDays(int validNoOfDays) {
        this.validNoOfDays = validNoOfDays;
    }
}
