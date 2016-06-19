package com.company.restaurant.dao;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.OrderCourseView;
import com.company.restaurant.model.OrderView;

import java.util.List;

/**
 * Created by Yevhen on 23.05.2016.
 */
public interface OrderCourseViewDao {
    void addCourseToOrder(OrderView orderView, Course course, int quantity);

    void takeCourseFromOrder(OrderView orderView, Course course, int quantity);

    List<OrderCourseView> findAllOrderCourses(OrderView orderView);

    OrderCourseView findOrderCourseByCourseId(OrderView orderView, int courseId);
}
