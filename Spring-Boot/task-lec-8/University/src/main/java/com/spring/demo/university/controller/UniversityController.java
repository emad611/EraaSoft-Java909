package com.spring.demo.university.controller;

import com.spring.demo.university.model.Course;
import com.spring.demo.university.model.Instructor;
import com.spring.demo.university.model.Student;
import com.spring.demo.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UniversityController {
    private UniversityService universityService;
 @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
     return universityService.createStudent(student);
    }
    @GetMapping("/students/{id}")
    public Student StudentGetById(@PathVariable Long id){
     return universityService.StudentGetById(id);
    }
    @GetMapping("/students")
    public List<Student> GetAllStudents(){
     return universityService.GetAllStudents();
    }
    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course){
     return universityService.createCourse(course);
    }
    @GetMapping("/course/{id}")
    public Course courseGetById(@PathVariable Long id){
     return universityService.courseGetById(id);
    }
    @GetMapping("/courses")
    public List<Course>getAllCourse(){
     return universityService.getAllCourse();
    }
    @PostMapping("/instructors")
    public Instructor createInstructor(@RequestBody Instructor instructor){
     return universityService.createInstructor(instructor);
    }
    @GetMapping("/instructor/{id}")
    public Instructor instructorGetById(@PathVariable Long id){
     return universityService.instructorGetById(id);
    }
    @GetMapping("/instructors")
    public List<Instructor>getAllInstructors(){
     return universityService.getAllInstructors();
    }
//    @PostMapping("/courses/{courseId}/instructor/{instructorId}")
//    public Course assignInstructorToCourse(
//            @PathVariable Long courseId,
//            @PathVariable Long instructorId) {
//        return universityService.assignInstructorToCourse(courseId, instructorId);
//    }
//@PostMapping("/students/{studentId}/course/{courseId}")
//public Student registerStudentToCourse(
//        @PathVariable Long studentId,
//        @PathVariable Long courseId) {
//    return universityService.getStudentsByCourseId(studentId, courseId);
//}

}
