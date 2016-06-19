package com.company.restaurant.dao;

import com.company.restaurant.model.OrderView;

import java.util.List;

/**
 * Created by Yevhen on 22.05.2016.
 */
public interface OrderViewDao {
    String orderEntityName();

    OrderView addOrder(OrderView orderView);

    void delOrder(OrderView orderView);

    OrderView findOrderById(int orderId);

    List<OrderView> findOrderByNumber(String orderNumber);

    List<OrderView> findAllOrders();

    List<OrderView> findAllOrders(String stateType);

    OrderView updOrderState(OrderView orderView, String stateType);
}
