package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // تجميع الموظفين حسب العمر + عدّ كل عمر كم موظف فيه
        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );
        // بنادى من حيث ref no create obj and method فقط ::
        Map<Integer,Long>countByAge=employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
        System.out.println(countByAge);
    }

    }

