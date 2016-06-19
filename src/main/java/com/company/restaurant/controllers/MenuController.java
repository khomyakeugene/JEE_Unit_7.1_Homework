package com.company.restaurant.controllers;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseView;

import java.util.List;

/**
 * Created by Yevhen on 17.06.2016.
 */
public interface MenuController {
    Menu addMenu(String name);

    void delMenu(String name);

    void delMenu(Menu menu);

    Menu findMenuByName(String name);

    Menu findMenuById(int menuId);

    List<Menu> findAllMenus();

    void addCourseToMenu(Menu menu, Course course);

    void delCourseFromMenu(Menu menu, Course course);

    List<MenuCourseView> findMenuCourses(Menu menu);

    MenuCourseView findMenuCourseByCourseId(Menu menu, int courseId);
}
