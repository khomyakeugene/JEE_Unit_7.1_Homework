package com.company.restaurant.application.data.list;

import com.company.restaurant.controllers.MenuController;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseView;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuCourseTableList extends ItemTableListProto<Menu, MenuCourseView>
        implements ItemTableList<Menu, MenuCourseView> {
    private static final String MENU_IS_EMPTY_MESSAGE = "Menu is empty";
    private static final String[] listHeader = new String[] {
            "Course Id",
            "Course name",
            "Category name",
            "Weight",
            "Cost",
            "Number in menu"
    };

    private MenuController menuController;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public List<MenuCourseView> prepareItemList(Menu menu) {
        return menuController.findMenuCourses(menu);
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(MenuCourseView menuCourseList) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(menuCourseList.getCourseId()));
        arrayList.add(menuCourseList.getCourseName());
        arrayList.add(menuCourseList.getCourseCategoryName());
        arrayList.add(toStringMaskNullAsEmpty(menuCourseList.getCourseWeight()));
        arrayList.add(toStringMaskNullAsEmpty(menuCourseList.getCourseCost()));
        arrayList.add(toStringMaskNullAsEmpty(menuCourseList.getCourseNumber()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected void listDataHasNotBeenFoundMessage() {
        errorMessage(MENU_IS_EMPTY_MESSAGE);
    }
}
