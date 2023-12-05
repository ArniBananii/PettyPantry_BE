package de.pettypantry.web.api;

import java.time.LocalDate;

public class UniqueIngredient {

    private int uniqueIngredientId;

    private int pantryId;

    private int ingredientid;

    private LocalDate expirationDate;

    public UniqueIngredient(int uniqueIngredientId, int pantryId, int ingredientid, LocalDate expirationDate) {
        this.uniqueIngredientId = uniqueIngredientId;
        this.pantryId = pantryId;
        this.ingredientid = ingredientid;
        this.expirationDate = expirationDate;
    }

    public int getUniqueIngredientId() {
        return uniqueIngredientId;
    }

    public int getPantryId() {
        return pantryId;
    }

    public int getIngredientid() {
        return ingredientid;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
