package com.company.restaurant.application.data.remover;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.controllers.WarehouseController;
import com.company.restaurant.model.Portion;
import com.company.restaurant.model.WarehouseView;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class WarehouseRemover extends ObjectRemoverProto<WarehouseView> {
    private static final String ENTER_INGREDIENT_AMOUNT_MESSAGE = "Please, enter ingredient amount";

    private WarehouseController warehouseController;
    private ObjectTableList<WarehouseView> warehouseTableList;
    private ObjectChooser<Portion> portionChooser;

    public void setWarehouseController(WarehouseController warehouseController) {
        this.warehouseController = warehouseController;
    }

    public void setWarehouseTableList(ObjectTableList<WarehouseView> warehouseTableList) {
        this.warehouseTableList = warehouseTableList;
    }

    public void setPortionChooser(ObjectChooser<Portion> portionChooser) {
        this.portionChooser = portionChooser;
    }

    @Override
    protected void deleteObject(WarehouseView warehouseView) {
        warehouseController.takeIngredientFromWarehouse(
                warehouseController.findIngredientById(warehouseView.getIngredientId()),
                warehouseController.findPortionById(warehouseView.getPortionId()),
                warehouseView.getAmount());
    }

    @Override
    protected WarehouseView chooseObjectFromList() {
        WarehouseView result = super.chooseObjectFromList();
        if (result != null) {
            // Show only this ingredient
            warehouseTableList.displayObjectList(
                    warehouseController.findIngredientInWarehouseById(result.getIngredientId()));
            // Get potion id
            Portion portion = portionChooser.chooseObjectFromList();
            if (portion != null) {
                result.setPortionId(portion.getPortionId());

                Float amount = Util.readInputPositiveFloat(ENTER_INGREDIENT_AMOUNT_MESSAGE, false);
                if (amount != null) {
                    result.setAmount(amount);

                    return result;
                }
            }
        }

        return null;
    }
}
