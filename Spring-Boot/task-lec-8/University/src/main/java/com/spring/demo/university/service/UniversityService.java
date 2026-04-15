package com.spring.demo.university.service;

import com.spring.demo.university.model.Course;
import com.spring.demo.university.model.Instructor;
import com.spring.demo.university.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UniversityService {
    //StudentAPI
    Student createStudent(Student student);
    List<Student> GetAllStudents();
    Student StudentGetById(Long id);
    Student getStudentsByCourseId(Long CourseId,Long StudentId);

    //Course API
    Course createCourse(Course course);
    Course courseGetById(Long id);
    List<Course>getAllCourse();
    Course assignInstructorToCourse(Long courseId, Long instructorId);

    //Instructor API
    Instructor createInstructor(Instructor instructor);
    Instructor instructorGetById(Long id);
    List<Instructor>getAllInstructors();
    List<Course> getCoursesByInstructorId(Long instructorId);
}
