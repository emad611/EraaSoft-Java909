package com.spring.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
    private String password;

    private String phone;

    private String address;

    private String role; // ADMIN / USER

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)// (مايحملش العربيات إلا لما تحتاجها)LAZY
    private List<Vehicle> vehicles;
}
