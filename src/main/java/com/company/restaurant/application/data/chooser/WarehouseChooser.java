package com.company.restaurant.application.data.chooser;

import com.company.restaurant.controllers.WarehouseController;
import com.company.restaurant.model.WarehouseView;

import java.util.List;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class WarehouseChooser extends ObjectChooserProto<WarehouseView, Integer>
        implements ObjectChooser<WarehouseView> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter ingredient identifier";

    private WarehouseController warehouseController;

    public void setWarehouseController(WarehouseController warehouseController) {
        this.warehouseController = warehouseController;
    }

    @Override
    protected WarehouseView findObject(Integer ingredientId) {
        List<WarehouseView> list = warehouseController.findIngredientInWarehouseById(ingredientId);

        return (list == null || list.size() == 0) ? null : list.get(0);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

}
