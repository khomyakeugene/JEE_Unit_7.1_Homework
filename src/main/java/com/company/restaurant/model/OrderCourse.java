package com.company.restaurant.model;

/**
 * Created by Yevhen on 13.06.2016.
 */
public class OrderCourse extends IntegerLinkObject {
    public int getCourseId() {
        return getFirstId();
    }

    public void setCourseId(int courseId) {
        setFirstId(courseId);
    }

    public int getOrderId() {
        return getSecondId();
    }

    public void setOrderId(int orderId) {
        setSecondId(orderId);
    }

    public Integer getCourseQuantity() {
        return getIntegerLinkData();
    }

    public void setCourseQuantity(Integer courseQuantity) {
        setIntegerLinkData(courseQuantity);
    }
}
