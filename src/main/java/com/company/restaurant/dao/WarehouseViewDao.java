package com.company.restaurant.dao;

import com.company.restaurant.model.Ingredient;
import com.company.restaurant.model.Portion;
import com.company.restaurant.model.WarehouseView;

import java.util.List;

/**
 * Created by Yevhen on 24.05.2016.
 */
public interface WarehouseViewDao {
    void addIngredientToWarehouse(Ingredient ingredient, Portion portion, float amount);

    void takeIngredientFromWarehouse(Ingredient ingredient, Portion portion, float amount);

    List<WarehouseView> findIngredientInWarehouseByName(String name);

    List<WarehouseView> findIngredientInWarehouseById(int ingredientId);

    List<WarehouseView> findAllWarehouseIngredients();

    List<WarehouseView> findAllElapsingWarehouseIngredients(float limit);
}
