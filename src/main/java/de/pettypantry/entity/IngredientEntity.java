package de.pettypantry.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Table(name = "ingredient")
@Entity(name = "ingredient")
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

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    private Set<UserEntity> users;

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
