package de.pettypantry.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IngredientModel {

    @JsonProperty("name")
    private String ingredientName;

    @JsonProperty("validDays")
    private int validNoOfDays;

    public IngredientModel() {
    }

    public IngredientModel(String ingredientName, int validNoOfDays) {
        this.ingredientName = ingredientName;
        this.validNoOfDays = validNoOfDays;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getValidNoOfDays() {
        return validNoOfDays;
    }
}
