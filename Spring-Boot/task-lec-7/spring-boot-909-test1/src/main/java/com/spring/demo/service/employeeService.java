package com.spring.demo.service;

import com.spring.demo.model.Employee;

import java.util.List;

public interface employeeService {
    List<Employee> getEmployees();
    List<Employee>getEmployeesById(List<Long>ids);
    Employee getEmployeeById(Long id);

    Employee createEmployee(Employee employee);

    List<Employee> createEmployees(List<Employee> employees);

    Employee updateEmployee(Employee employee);
    List<Employee>updateEmployees(List<Employee>employees);

    void deleteAllEmployees();

    void deleteEmployeeById(Long id);

    void deleteAllEmployeesByIds(List<Long> ids);
    List<Employee> employeeFindByName(String name);

}
