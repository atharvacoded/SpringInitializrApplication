package org.example.controller;
import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;
    //StudentService service = new StudentService();


    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return "Student added successfully!";
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted successfully!";
    }
}
