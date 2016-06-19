package com.company.restaurant.model;

/**
 * Created by Yevhen on 23.05.2016.
 */
public class FloatLinkObject extends com.company.restaurant.model.LinkObject {
    public Float getFloatLinkData() {
        return (linkData == null) ? null : Float.parseFloat(linkData);
    }

    public void setFloatLinkData(Float floatValue) {
        this.linkData = (floatValue == null) ? null : Float.toString(floatValue);
    }
}
