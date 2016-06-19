package com.company.restaurant.dao;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 11.06.2016.
 */
public interface MenuCourseDao {
    void addCourseToMenu(Menu menu, Course course);

    void delCourseFromMenu(Menu menu, Course course);
}
