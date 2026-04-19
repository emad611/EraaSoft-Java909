package com.spring.demo.service;



import com.spring.demo.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDTO);
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDTO);
    void removeEmployee(Long id);
    List<EmployeeDto> getEmployees();
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto>getEmployeesByIds(List<Long>ids);
    List<EmployeeDto>getEmployeesByName(List<String>names);
    List<EmployeeDto>getEmployeeByAddress(List<String>address);

}
