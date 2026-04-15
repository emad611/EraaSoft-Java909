package com.spring.demo.university.service.Impl;

import com.spring.demo.university.model.Course;
import com.spring.demo.university.model.Instructor;
import com.spring.demo.university.model.Student;
import com.spring.demo.university.repo.CourseRepository;
import com.spring.demo.university.repo.InstructorRepository;
import com.spring.demo.university.repo.StudentRepository;
import com.spring.demo.university.service.UniversityService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversityServiceImpl implements UniversityService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private InstructorRepository instructorRepository;

    public UniversityServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Student createStudent(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public List<Student> GetAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student StudentGetById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student getStudentsByCourseId(Long CourseId,Long StudentId) {
        return null;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course courseGetById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course assignInstructorToCourse(Long courseId, Long instructorId) {
        return null;
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor instructorGetById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public List<Course> getCoursesByInstructorId(Long instructorId) {
        return List.of();
    }
}
