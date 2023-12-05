package de.pettypantry.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Table(name = "INGREDIENT")
@Entity(name = "INGREDIENT")
public class IngredientEntity {

    @Id
    private int ingredientId;

    @Column(name = "name", nullable = false)
    private String ingredientName;

    @Column(name = "validNoOfDays")
    private int validNoOfDays;

    @OneToMany(mappedBy = "ingredient", fetch = FetchType.EAGER)
    private Set<UniqueIngredientEntity> uniqueIngredients;

    public IngredientEntity(String ingredientName, int validNoOfDays) {
        this.ingredientName = ingredientName;
        this.validNoOfDays = validNoOfDays;
    }

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

    public Set<UniqueIngredientEntity> getUniqueIngredients() {
        return uniqueIngredients;
    }
}
