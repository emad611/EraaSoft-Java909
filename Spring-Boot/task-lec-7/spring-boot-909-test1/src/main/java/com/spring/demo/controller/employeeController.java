package com.spring.demo.controller;

import com.spring.demo.model.Employee;
import com.spring.demo.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class employeeController {
    private employeeService employeeService;
    @Autowired
    public employeeController(employeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/save")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @PostMapping("/employees/batch")
    public List<Employee> createEmployees(@RequestBody List<Employee> employees) {
        return employeeService.createEmployees(employees);
    }
   @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @PutMapping("/employees/update")
    public List<Employee>updateEmployees(@RequestParam("ids") List<Employee>employees){
        return employeeService.updateEmployees(employees);
    }
    @GetMapping("/employees")
    public List<Employee>getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/Employees/ids/")
    public List<Employee>getEmployeesById(@RequestParam("ids") List<Long>ids){
        return employeeService.getEmployeesById(ids);
    }
   @DeleteMapping("/employees")
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployees();
    }
    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }
    @DeleteMapping("/employees/ids")
     public void deleteAllEmployeesByIds(@RequestParam("ids") List<Long>ids){
        employeeService.deleteAllEmployeesByIds(ids);
     }
    @GetMapping("employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/employee/name")
    public List<Employee> employeeFindByName(@RequestParam String name) {
        return employeeService.employeeFindByName(name);
    }

}
