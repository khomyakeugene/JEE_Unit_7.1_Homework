package com.company.restaurant.application.data.list;

import com.company.restaurant.controllers.KitchenController;
import com.company.restaurant.model.CookedCourseView;
import com.company.util.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class CookedCourseTableList extends ObjectTableListProto<CookedCourseView>
        implements ObjectTableList<CookedCourseView> {
    private static final String THERE_ARE_NO_COOKED_COURSES_YET_MESSAGE = "There are no cooked courses yet";
    private static final String[] listHeader = new String[]{
            "Course Id",
            "Course name",
            "Personnel name",
            "Cooking weight",
            "Cooking datetime"
    };

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private KitchenController kitchenController;

    public void setKitchenController(KitchenController kitchenController) {
        this.kitchenController = kitchenController;
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(CookedCourseView cookedCourseView) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(cookedCourseView.getCourseId()));
        arrayList.add(cookedCourseView.getCourseName());
        arrayList.add(cookedCourseView.getEmployeeFirstName() + " " + cookedCourseView.getEmployeeSecondName());
        arrayList.add(toStringMaskNullAsEmpty(cookedCourseView.getCookWeight()));
        arrayList.add(simpleDateFormat.format(cookedCourseView.getCookDatetime().getTime()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    public List<CookedCourseView> prepareObjectList() {
        return kitchenController.findAllCookedCourses();
    }

    @Override
    protected void listDataHasNotBeenFoundMessage() {
        Util.printMessage(THERE_ARE_NO_COOKED_COURSES_YET_MESSAGE);
    }
}
