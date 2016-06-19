package com.company.restaurant.application.data.collector;

import com.company.restaurant.controllers.CourseController;
import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.OrderCourseView;
import com.company.restaurant.model.OrderView;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderCourseCollector extends ItemCollectorProto<OrderView, Course, OrderCourseView>
        implements ItemCollector<OrderView> {

    protected OrderController orderController;
    protected CourseController courseController;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setCourseController(CourseController courseController) {
        this.courseController = courseController;
    }

    @Override
    protected void addItemToObject(OrderView orderView, Course course) {
        orderController.addCourseToOrder(orderView, course, 1);
    }

    @Override
    protected void delItemFromObject(OrderView orderView, OrderCourseView orderCourse) {
        orderController.takeCourseFromOrder(orderView,
                courseController.findCourseById(orderCourse.getCourseId()), 1);

    }
}
