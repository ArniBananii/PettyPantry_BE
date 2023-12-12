package de.pettypantry.web.api;

import java.time.LocalDate;

public class UniqueIngredient {

    private int uniqueIngredientID;

    private int pantryID;

    private int ingredientID;

    private LocalDate expirationDate;

    public UniqueIngredient(int uniqueIngredientID, int pantryID, int ingredientID, LocalDate expirationDate) {
        this.uniqueIngredientID = uniqueIngredientID;
        this.pantryID = pantryID;
        this.ingredientID = ingredientID;
        this.expirationDate = expirationDate;
    }

    public int getUniqueIngredientID() {
        return uniqueIngredientID;
    }

    public int getPantryID() {
        return pantryID;
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
