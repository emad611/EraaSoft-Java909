package com.spring.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private float salary;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<EmailModel> emails=new ArrayList<>();
}
