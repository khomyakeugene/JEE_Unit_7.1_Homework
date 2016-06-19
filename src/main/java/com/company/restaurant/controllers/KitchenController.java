package com.company.restaurant.controllers;

import com.company.restaurant.model.CookedCourseView;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Employee;

import java.util.List;

/**
 * Created by Yevhen on 17.06.2016.
 */
public interface KitchenController {
    CookedCourseView addCookedCourse(Course course, Employee employee, Float weight);

    void delCookedCourse(CookedCourseView cookedCourseView);

    List<CookedCourseView> findAllCookedCourses();
}
