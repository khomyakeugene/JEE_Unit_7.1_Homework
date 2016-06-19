package com.company.restaurant.dao;

import com.company.restaurant.model.Ingredient;
import com.company.restaurant.model.Portion;

/**
 * Created by Yevhen on 16.06.2016.
 */
public interface WarehouseDao {
    void addIngredientToWarehouse(Ingredient ingredient, Portion portion, float amount);

    void takeIngredientFromWarehouse(Ingredient ingredient, Portion portion, float amount);
}
