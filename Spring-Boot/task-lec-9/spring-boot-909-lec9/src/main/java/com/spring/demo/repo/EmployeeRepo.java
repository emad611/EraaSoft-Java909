package com.spring.demo.repo;

import com.spring.demo.model.EmailModel;
import com.spring.demo.model.Employee;
import com.spring.demo.service.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    @Query("SELECT e FROM Employee e WHERE e.name IN :names")
    List<Employee> findEmployeesByUserName(@Param("names") List<String> names);
    @Query("SELECT e FROM Employee e WHERE e.address IN :addresses")
    List<Employee> findEmployeesByAddress(@Param("addresses") List<String> addresses);
}
