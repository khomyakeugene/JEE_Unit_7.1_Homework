package com.company.restaurant.dao;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseView;

import java.util.List;

/**
 * Created by Yevhen on 21.05.2016.
 */
public interface MenuCoursesViewDao {
    void addCourseToMenu(Menu menu, Course course);

    void delCourseFromMenu(Menu menu, Course course);

    List<MenuCourseView> findMenuCourses(Menu menu);

    MenuCourseView findMenuCourseByCourseId(Menu menu, int courseId);
}
