package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.controllers.KitchenController;
import com.company.restaurant.model.CookedCourseView;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Employee;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class CookedCourseAdder extends ObjectAdderProto<CookedCourseView> {
    private static final String ENTER_WEIGHT_MESSAGE = "Please, enter course weight";
    private static final String ALREADY_COOKED_COURSES_MESSAGE = "Already cooked courses:";

    private KitchenController kitchenController;
    private ObjectChooser<Course> courseChooser;
    private ObjectChooser<Employee> employeeChooser;

    public void setKitchenController(KitchenController kitchenController) {
        this.kitchenController = kitchenController;
    }

    public void setCourseChooser(ObjectChooser<Course> courseChooser) {
        this.courseChooser = courseChooser;
    }

    public void setEmployeeChooser(ObjectChooser<Employee> employeeChooser) {
        this.employeeChooser = employeeChooser;
    }

    @Override
    protected CookedCourseView addObject() {
        CookedCourseView result = null;

        Course course = courseChooser.chooseObjectFromList();
        if (course != null) {
            Employee employee = employeeChooser.chooseObjectFromList();
            if (employee != null) {
                Float weight = Util.readInputPositiveFloat(ENTER_WEIGHT_MESSAGE, true);
                if (weight != null) {
                    kitchenController.addCookedCourse(course, employee, weight);
                    dataHasBeenSuccessfullyAddedMessage();

                    // Unfortunately, "right now" just "manually imitation" here (hope - temporarily...)  ...
                    result = new CookedCourseView();
                    result.setCourseId(course.getCourseId());
                    result.setEmployeeId(employee.getEmployeeId());
                    result.setCookWeight(weight);
                }
            }
        }

        return result;
    }

    @Override
    protected String getExistingDataMessage() {
        return ALREADY_COOKED_COURSES_MESSAGE;
    }
}
