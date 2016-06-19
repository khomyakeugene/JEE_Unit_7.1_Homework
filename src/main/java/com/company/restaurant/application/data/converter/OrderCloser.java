package com.company.restaurant.application.data.converter;

import com.company.restaurant.application.data.service.ObjectProcessorProto;
import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.OrderView;

/**
 * Created by Yevhen on 01.06.2016.
 */
public class OrderCloser extends ObjectProcessorProto<OrderView> {
    private static final String ORDER_HAS_BEEN_CLOSED_PATTERN = "Order with number <%s> has been closed";

    private OrderController orderController;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    @Override
    protected String processObject(OrderView orderView) {
        orderController.closeOrder(orderView);

        return null;
    }

    @Override
    protected String getActionHasBeenSuccessfullyPerformedMessage(OrderView orderView) {
        return String.format(ORDER_HAS_BEEN_CLOSED_PATTERN, orderView.getOrderNumber());
    }
}
