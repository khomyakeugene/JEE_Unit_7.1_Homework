package com.company.restaurant.controllers;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.OrderCourseView;
import com.company.restaurant.model.OrderView;

import java.util.List;

/**
 * Created by Yevhen on 17.06.2016.
 */
public interface OrderController {
    OrderView addOrder(OrderView orderView);

    void delOrder(OrderView orderView);

    OrderView findOrderById(int orderId);

    OrderView closeOrder(OrderView orderView);

    List<OrderView> findAllOrders();

    List<OrderView> findAllOrders(String stateType);

    List<OrderView> findAllOpenOrders();

    List<OrderView> findAllClosedOrders();

    String addCourseToOrder(OrderView orderView, Course course, int quantity);

    String addCourseToOrder(OrderView orderView, Course course);

    String takeCourseFromOrder(OrderView orderView, Course course, int quantity);

    String takeCourseFromOrder(OrderView orderView, Course course);

    List<OrderCourseView> findAllOrderCourses(OrderView orderView);

    List<OrderView> findOrderByNumber(String orderNumber);

    OrderCourseView findOrderCourseByCourseId(OrderView orderView, int courseId);

    OrderView updOrderState(OrderView orderView, String stateType);
}
