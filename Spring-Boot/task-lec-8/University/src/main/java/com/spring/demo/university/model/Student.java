package com.spring.demo.university.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String email;
    @ManyToMany(mappedBy = "students")
   private List<Course> coursers=new ArrayList<>();

    public List<Course> getCoursers() {
        return coursers;
    }

    public void setCoursers(List<Course> coursers) {
        this.coursers = coursers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
