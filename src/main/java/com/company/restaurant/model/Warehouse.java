package com.company.restaurant.model;

/**
 * Created by Yevhen on 15.06.2016.
 */
public class Warehouse extends FloatLinkObject {
    public int getIngredientId() {
        return getFirstId();
    }

    public void setIngredientId(int ingredientId) {
        setFirstId(ingredientId);
    }

    public int getPortionId() {
        return getSecondId();
    }

    public void setPortionId(int portionId) {
        setSecondId(portionId);
    }

    public Float getAmount() {
        return getFloatLinkData();
    }

    public void setAmount(Float amount) {
        setFloatLinkData(amount);
    }
}
