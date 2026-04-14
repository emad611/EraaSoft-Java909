package com.spring.demo.service.Impl;

import com.spring.demo.model.Employee;
import com.spring.demo.repo.employeeRepo;
import com.spring.demo.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class employeeServiceImpl implements employeeService {

private employeeRepo employeeRepo;
    @Autowired
    public employeeServiceImpl(employeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> getEmployeesById(List<Long> ids) {

        return employeeRepo.findAllById(ids);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> createEmployees(List<Employee> employees) {

        return employeeRepo.saveAll(employees);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> updateEmployees(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    @Override
    public void deleteAllEmployees() {
employeeRepo.deleteAll();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if(employeeRepo.existsById(id)){
            employeeRepo.deleteById(id);
        }
        else{
            throw new RuntimeException("Employee not found with id: " + id);
        }

    }
    @Override
    public void deleteAllEmployeesByIds(List<Long> ids) {
employeeRepo.deleteAllByIdInBatch(ids);
    }

    @Override
    public List<Employee> employeeFindByName(String name) {
        return employeeRepo.findByNameLike(name);
    }


}
