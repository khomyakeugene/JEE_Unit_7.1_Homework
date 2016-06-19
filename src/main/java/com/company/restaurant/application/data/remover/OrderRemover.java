package com.company.restaurant.application.data.remover;

import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.OrderView;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class OrderRemover extends ObjectRemoverProto<OrderView> {
    private OrderController orderController;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    @Override
    protected void deleteObject(OrderView orderView) {
        orderController.delOrder(orderView);
    }
}
