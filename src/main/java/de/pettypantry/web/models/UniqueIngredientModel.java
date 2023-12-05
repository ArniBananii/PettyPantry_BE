package de.pettypantry.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class UniqueIngredientModel {

    @JsonProperty("pantryid")
    private int pantryId;

    @JsonProperty("ingredientid")
    private int ingredientId;

    @JsonProperty("expirationDate")
    private LocalDate expirationDate;

    public UniqueIngredientModel(int pantryId, int ingredientId, LocalDate expirationDate) {
        this.pantryId = pantryId;
        this.ingredientId = ingredientId;
        this.expirationDate = expirationDate;
    }

    public UniqueIngredientModel() {
    }

    public int getPantryId() {
        return pantryId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
