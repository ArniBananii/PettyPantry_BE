package de.pettypantry.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class UniqueIngredientModel {

    @JsonProperty("pantryID")
    private int pantryId;

    @JsonProperty("ingredientID")
    private int ingredientId;

    public UniqueIngredientModel(int pantryId, int ingredientId) {
        this.pantryId = pantryId;
        this.ingredientId = ingredientId;
    }

    public UniqueIngredientModel() {
    }

    public int getPantryId() {
        return pantryId;
    }

    public int getIngredientId() {
        return ingredientId;
    }
}
