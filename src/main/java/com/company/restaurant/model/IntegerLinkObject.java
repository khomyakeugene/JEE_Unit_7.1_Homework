package com.company.restaurant.model;

/**
 * Created by Yevhen on 23.05.2016.
 */
public class IntegerLinkObject extends com.company.restaurant.model.LinkObject {
    public Integer getIntegerLinkData() {
        return (linkData == null) ? null : Integer.parseInt(linkData);
    }

    public void setIntegerLinkData(Integer intValue) {
        this.linkData = (intValue == null) ? null : Integer.toString(intValue);
    }
}
