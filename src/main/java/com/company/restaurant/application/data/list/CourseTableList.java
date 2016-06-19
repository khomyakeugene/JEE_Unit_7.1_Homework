package com.company.restaurant.application.data.list;

import com.company.restaurant.controllers.CourseController;
import com.company.restaurant.model.Course;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class CourseTableList extends ObjectTableListProto<Course> implements ObjectTableList<Course> {
    private static final String[] listHeader = new String[] {
            "Course Id",
            "Course name",
            "Category name",
            "Weight",
            "Cost"
    };

    private CourseController courseController;

    public void setCourseController(CourseController courseController) {
        this.courseController = courseController;
    }

    @Override
    public List<Course> prepareObjectList() {
        return courseController.findAllCourses();
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Course course) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(course.getCourseId()));
        arrayList.add(course.getName());
        arrayList.add(course.getCourseCategoryName());
        arrayList.add(toStringMaskNullAsEmpty(course.getWeight()));
        arrayList.add(toStringMaskNullAsEmpty(course.getCost()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

}
