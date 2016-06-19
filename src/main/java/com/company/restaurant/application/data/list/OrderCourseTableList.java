package com.company.restaurant.application.data.list;

import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.OrderCourseView;
import com.company.restaurant.model.OrderView;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderCourseTableList extends ItemTableListProto<OrderView, OrderCourseView>
        implements ItemTableList<OrderView, OrderCourseView> {
    private static final String ORDER_IS_EMPTY_MESSAGE = "Order is empty";
    private static final String[] listHeader = new String[] {
            "Course Id",
            "Course name",
            "Category name",
            "Weight",
            "Cost",
            "Quantity in orderView"
    };

    private OrderController orderController;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }


    @Override
    public List<OrderCourseView> prepareItemList(OrderView orderView) {
        return orderController.findAllOrderCourses(orderView);
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(OrderCourseView orderCourse) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(orderCourse.getCourseId()));
        arrayList.add(orderCourse.getCourseName());
        arrayList.add(orderCourse.getCourseCategoryName());
        arrayList.add(toStringMaskNullAsEmpty(orderCourse.getCourseWeight()));
        arrayList.add(toStringMaskNullAsEmpty(orderCourse.getCourseCost()));
        arrayList.add(Integer.toString(orderCourse.getCourseQuantity()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected void listDataHasNotBeenFoundMessage() {
        errorMessage(ORDER_IS_EMPTY_MESSAGE);
    }
}
