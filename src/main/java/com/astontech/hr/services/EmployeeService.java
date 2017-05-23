package com.astontech.hr.services;

import com.astontech.hr.domain.Employee;

/**
 * Created by Jonathan.Marshall on 3/20/2017.
 */
public interface EmployeeService
{
    Iterable<Employee> listAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee saveEmployee(Employee employee);

    Iterable<Employee> saveEmployeeList(Iterable<Employee> employeeIterable);

    void deleteEmployee(Integer id);
}
