package com.company.restaurant.controllers;

import com.company.restaurant.model.Ingredient;
import com.company.restaurant.model.Portion;
import com.company.restaurant.model.WarehouseView;

import java.util.List;

/**
 * Created by Yevhen on 17.06.2016.
 */
public interface WarehouseController {
    void addIngredientToWarehouse(Ingredient ingredient, Portion portion, float amount);

    void takeIngredientFromWarehouse(Ingredient ingredient, Portion portion, float amount);

    List<WarehouseView> findIngredientInWarehouseByName(String name);

    List<WarehouseView> findIngredientInWarehouseById(int ingredientId);

    List<WarehouseView> findAllWarehouseIngredients();

    List<WarehouseView> findAllElapsingWarehouseIngredients(float limit);

    List<Ingredient> findAllIngredients();

    Ingredient findIngredientById(int ingredientId);

    List<Portion> findAllPortions();

    Portion findPortionById(int portionId);
}
