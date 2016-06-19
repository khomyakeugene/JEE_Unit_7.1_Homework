package com.company.restaurant.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Yevhen on 14.06.2016.
 */
public class CookedCourse implements Serializable {
    private int employeeId;
    private int courseId;
    private Timestamp cookDatetime;
    private Float cookWeight;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Timestamp getCookDatetime() {
        return cookDatetime;
    }

    public void setCookDatetime(Timestamp cookDatetime) {
        this.cookDatetime = cookDatetime;
    }

    public Float getCookWeight() {
        return cookWeight;
    }

    public void setCookWeight(Float cookWeight) {
        this.cookWeight = cookWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CookedCourse)) return false;

        CookedCourse that = (CookedCourse) o;

        return employeeId == that.employeeId && courseId == that.courseId &&
                (cookDatetime != null ? cookDatetime.equals(that.cookDatetime) :
                        that.cookDatetime == null && (cookWeight != null ? cookWeight.equals(that.cookWeight) :
                                that.cookWeight == null));

    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + courseId;
        result = 31 * result + (cookDatetime != null ? cookDatetime.hashCode() : 0);
        result = 31 * result + (cookWeight != null ? cookWeight.hashCode() : 0);
        return result;
    }
}
