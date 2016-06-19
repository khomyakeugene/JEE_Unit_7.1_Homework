package com.company.restaurant.model;

import java.io.Serializable;

/**
 * Created by Yevhen on 21.05.2016.
 */
public class LinkObject  implements Serializable {
    private int firstId;
    private int secondId;
    protected String linkData;

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

    public String getLinkData() {
        return linkData;
    }

    public void setLinkData(String linkData) {
        this.linkData = linkData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkObject)) return false;

        LinkObject that = (LinkObject) o;

        return firstId == that.firstId && secondId == that.secondId;

    }

    @Override
    public int hashCode() {
        int result = firstId;
        result = 31 * result + secondId;
        return result;
    }
}
