package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );
        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)   // أول شيء: ترتيب حسب الراتب
                        .thenComparing(Employee::getName))          // ثاني شيء: ترتيب حسب الاسم لو الرواتب متساوية
                .collect(Collectors.toList());                      // جمع النتائج في قائمة
        System.out.println(sorted);
    }

    }

