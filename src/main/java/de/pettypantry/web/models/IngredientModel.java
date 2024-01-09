package de.pettypantry.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IngredientModel {

    @JsonProperty("name")
    private String ingredientName;

    @JsonProperty("validDays")
    private int validNoOfDays;

    @JsonProperty("imageURL")
    private String imageURL;

    public IngredientModel() {
    }

    public IngredientModel(String ingredientName, int validNoOfDays, String imageURL) {
        this.ingredientName = ingredientName;
        this.validNoOfDays = validNoOfDays;
        this.imageURL = imageURL;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getValidNoOfDays() {
        return validNoOfDays;
    }

    public String getImageURL() {
        return imageURL;
    }
}
