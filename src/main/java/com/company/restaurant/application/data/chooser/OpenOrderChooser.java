package com.company.restaurant.application.data.chooser;

import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.OrderView;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class OpenOrderChooser extends ObjectChooserProto<OrderView, Integer>
        implements ObjectChooser<OrderView> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter order identifier";

    private OrderController orderController;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    @Override
    protected OrderView findObject(Integer orderId) {
        return orderController.findOrderById(orderId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

}
