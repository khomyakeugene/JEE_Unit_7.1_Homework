package com.company.restaurant.model;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class Ingredient extends com.company.restaurant.model.SimpleDic {
    public int getIngredientId() {
        return getId();
    }

    public void setIngredientId(int ingredientId) {
        setId(ingredientId);
    }
}
