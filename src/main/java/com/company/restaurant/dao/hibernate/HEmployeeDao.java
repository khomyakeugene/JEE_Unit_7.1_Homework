package com.company.restaurant.dao.hibernate;

import com.company.restaurant.dao.EmployeeDao;
import com.company.restaurant.dao.hibernate.proto.HDaoEntity;
import com.company.restaurant.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yevhen on 10.06.2016.
 */
public class HEmployeeDao extends HDaoEntity<Employee> implements EmployeeDao {
    private static final String FIRST_NAME_ATTRIBUTE_NAME = "firstName";
    private static final String SECOND_NAME_ATTRIBUTE_NAME = "secondName";

    @Override
    protected void initMetadata() {

    }

    @Transactional
    @Override
    public Employee addEmployee(Employee employee) {
        return save(employee);
    }

    @Transactional
    @Override
    public void delEmployee(Employee employee) {
        delete(employee);
    }

    @Transactional
    @Override
    public void delEmployee(int employeeId) {
        delete(employeeId);
    }

    @Transactional
    @Override
    public Employee findEmployeeById(int employeeId) {
        return findObjectById(employeeId);
    }

    @Transactional
    @Override
    public List<Employee> findEmployeeByFirstName(String firstName) {
        return findObjectsByAttributeValue(FIRST_NAME_ATTRIBUTE_NAME, firstName);
    }

    @Transactional
    @Override
    public List<Employee> findEmployeeBySecondName(String secondName) {
        return findObjectsByAttributeValue(SECOND_NAME_ATTRIBUTE_NAME, secondName);
    }

    @Transactional
    @Override
    public List<Employee> findEmployeeByFirstAndSecondName(String firstName, String secondName) {
        List<Employee> result;

        if (firstName != null && !firstName.isEmpty() && secondName != null && !secondName.isEmpty()) {
            result = findObjectsByTwoAttributeValues(FIRST_NAME_ATTRIBUTE_NAME, firstName,
                    SECOND_NAME_ATTRIBUTE_NAME, secondName);
        } else if (firstName != null && !firstName.isEmpty()) {
            result = findEmployeeByFirstName(firstName);
        } else if (secondName != null && !secondName.isEmpty()) {
            result = findEmployeeBySecondName(secondName);
        } else {
            result = findAllEmployees();
        }

        return result;
    }

    @Transactional
    @Override
    public List<Employee> findAllEmployees() {
        return findAllObjects();
    }
}
