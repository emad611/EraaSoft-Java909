package com.spring.demo.repo;

import com.spring.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface employeeRepo extends JpaRepository<Employee,Long> {
    List<Employee> findByNameStartingWith(String prefix);

    List<Employee> findByNameLike(String pattern);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE CONCAT(:name, '%')")
    List<Employee> findByNameStartingWithQuery(@Param("name") String name);

    @Query(value = "SELECT * FROM employee WHERE name LIKE :name || '%'", nativeQuery = true)
    List<Employee> findByNameNative(@Param("name") String name);

}
