package com.company.restaurant.application.data.list;

import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.OrderView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class OrderTableList extends ObjectTableListProto<OrderView> implements ObjectTableList<OrderView> {
    private static final String[] listHeader = new String[] {
            "Order Id",
            "Order number",
            "Order datetime",
            "Status",
            "Personnel name",
            "Table number"
    };

    protected OrderController orderController;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(OrderView orderView) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(orderView.getOrderId()));
        arrayList.add(orderView.getOrderNumber());
        arrayList.add(simpleDateFormat.format(orderView.getOrderDatetime().getTime()));
        arrayList.add(orderView.getStateTypeName());
        arrayList.add(orderView.getEmployeeFirstName() + " " + orderView.getEmployeeSecondName());
        arrayList.add(Integer.toString(orderView.getTableNumber()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    public List<OrderView> prepareObjectList() {
        return orderController.findAllOrders();
    }

}
