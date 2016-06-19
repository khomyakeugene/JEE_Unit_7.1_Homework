package com.company.restaurant.model;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class WarehouseView extends FloatLinkObject {
    private String ingredientName;
    private int portionTypeId;
    private int measuringTypeId;
    private Float portionAmount;
    private String portionDescription;
    private String portionTypeName;
    private String MeasuringTypeCode;
    private String measuringTypeName;

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

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getPortionTypeId() {
        return portionTypeId;
    }

    public void setPortionTypeId(int portionTypeId) {
        this.portionTypeId = portionTypeId;
    }

    public int getMeasuringTypeId() {
        return measuringTypeId;
    }

    public void setMeasuringTypeId(int measuringTypeId) {
        this.measuringTypeId = measuringTypeId;
    }

    public Float getPortionAmount() {
        return portionAmount;
    }

    public void setPortionAmount(Float portionAmount) {
        this.portionAmount = portionAmount;
    }

    public String getPortionDescription() {
        return portionDescription;
    }

    public void setPortionDescription(String portionDescription) {
        this.portionDescription = portionDescription;
    }

    public String getPortionTypeName() {
        return portionTypeName;
    }

    public void setPortionTypeName(String portionTypeName) {
        this.portionTypeName = portionTypeName;
    }

    public String getMeasuringTypeCode() {
        return MeasuringTypeCode;
    }

    public void setMeasuringTypeCode(String measuringTypeCode) {
        MeasuringTypeCode = measuringTypeCode;
    }

    public String getMeasuringTypeName() {
        return measuringTypeName;
    }

    public void setMeasuringTypeName(String measuringTypeName) {
        this.measuringTypeName = measuringTypeName;
    }
}
