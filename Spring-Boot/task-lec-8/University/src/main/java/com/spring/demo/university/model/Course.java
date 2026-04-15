package com.spring.demo.university.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToMany
    @JoinTable
            (
                    name="Student_Course",
                    joinColumns = @JoinColumn(name = "Course_id"),
                    inverseJoinColumns = @JoinColumn(name = "Student_id")
            )
    List<Student> students=new ArrayList<>();
    @ManyToOne
    private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }
    public Course() {

    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
