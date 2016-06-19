package com.company.restaurant.controllers;

import com.company.restaurant.model.Employee;
import com.company.restaurant.model.JobPosition;

import java.util.List;

/**
 * Created by Yevhen on 17.06.2016.
 */
public interface EmployeeController {
    JobPosition addJobPosition(String name);

    void delJobPosition(String name);

    JobPosition findJobPositionByName(String name);

    JobPosition findJobPositionById(int jobPositionId);

    List<JobPosition> findAllJobPositions();

    Employee addEmployee(Employee employee);

    void delEmployee(Employee employee);

    void delEmployee(int employeeId);

    List<Employee> findAllEmployees();

    List<Employee> findEmployeeByFirstName(String firstName);

    List<Employee> findEmployeeBySecondName(String lastName);

    List<Employee> findEmployeeByFirstAndSecondName(String firstName, String secondName);

    Employee findEmployeeById(int employeeId);
}
