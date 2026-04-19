package com.spring.demo.controller;

import com.spring.demo.dto.EmployeeDto;
import com.spring.demo.model.Employee;
import com.spring.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
   private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public EmployeeDto createEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }
    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id,@RequestBody @Valid EmployeeDto employeeDto){
        return employeeService.updateEmployee(id,employeeDto);
    }
    @DeleteMapping("/{id}")
    public void removeEmployee(@PathVariable Long id){
         employeeService.removeEmployee(id);
    }
    @GetMapping
    public List<EmployeeDto> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/ids")
    public List<EmployeeDto>getEmployeesByIds(@RequestParam("ids") List<Long>ids){
        return employeeService.getEmployeesByIds(ids);
    }
    @GetMapping("/names")
    public List<EmployeeDto>getEmployeesByName(@RequestParam("names") List<String>names){
        return employeeService.getEmployeesByName(names);
    }
    @GetMapping("/addresses")
    public List<EmployeeDto>getEmployeeByAddress(@RequestParam("addresses") List<String>addresses){
        return employeeService.getEmployeeByAddress(addresses);
    }

}
