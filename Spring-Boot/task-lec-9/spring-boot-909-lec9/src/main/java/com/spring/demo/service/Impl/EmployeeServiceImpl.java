package com.spring.demo.service.Impl;

import com.spring.demo.dto.EmployeeDto;
import com.spring.demo.model.Employee;
import com.spring.demo.repo.EmployeeRepo;
import com.spring.demo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee saved = employeeRepo.save(employee);
        return modelMapper.map(saved, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDTO) {
        Employee existingEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setAge(employeeDTO.getAge());
        existingEmployee.setAddress(employeeDTO.getAddress());
        existingEmployee.setSalary(employeeDTO.getSalary());

        Employee updated = employeeRepo.save(existingEmployee);
        return modelMapper.map(updated, EmployeeDto.class);
    }

    @Override
    public void removeEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getEmployeesByIds(List<Long> ids) {
        List<Employee> employees = employeeRepo.findAllById(ids);
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByName(List<String> names) {
        List<Employee> employees = employeeRepo.findEmployeesByUserName(names);
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeeByAddress(List<String> address) {
        List<Employee> employees = employeeRepo.findEmployeesByAddress(address);
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }
}