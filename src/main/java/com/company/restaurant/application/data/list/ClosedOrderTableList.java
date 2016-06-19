package com.company.restaurant.application.data.list;

import com.company.restaurant.model.OrderView;

import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class ClosedOrderTableList extends OrderTableList implements ObjectTableList<OrderView> {
    @Override
    public List<OrderView> prepareObjectList() {
        return orderController.findAllClosedOrders();
    }
}
