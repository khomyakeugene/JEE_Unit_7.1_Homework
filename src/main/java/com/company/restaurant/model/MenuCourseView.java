package com.company.restaurant.model;

/**
 * Created by Yevhen on 21.05.2016.
 */
public class MenuCourseView extends IntegerLinkObject {
    // Is is dangerous to inherit <MenuCourseView> from <MenuCourse >, because, I cannot understand why, but
    // when using then separate hibernate-hbm.xml-mapping, hibernate supposes, that <MenuCourse>-class should be
    // mapped to the same table (view) <v_menu_courses_list> as its descendant <MenuCourseView>-class, but not
    // to concrete table <menu_courses_list>, as I am telling hibernate in MenuCourse.hbm.xml file,
    // and "right now" I do not know how I can avoid to "produce" such "inheritance"
    private int courseCategoryId;
    private String courseName;
    private float courseWeight;
    private float courseCost;
    private String courseCategoryName;

    public int getMenuId() {
        return getFirstId();
    }

    public void setMenuId(int orderId) {
        setFirstId(orderId);
    }

    public int getCourseId() {
        return getSecondId();
    }

    public void setCourseId(int courseId) {
        setSecondId(courseId);
    }

    public Integer getCourseNumber() {
        return getIntegerLinkData();
    }

    public void setCourseNumber(Integer courseNumber) {
        setIntegerLinkData(courseNumber);
    }

    public int getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(int courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public float getCourseWeight() {
        return courseWeight;
    }

    public void setCourseWeight(float courseWeight) {
        this.courseWeight = courseWeight;
    }

    public float getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(float courseCost) {
        this.courseCost = courseCost;
    }

    public String getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(String courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }
}
