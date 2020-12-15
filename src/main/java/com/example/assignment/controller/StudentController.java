package com.example.assignment.controller;

import com.example.assignment.entity.Student;
import com.example.assignment.repository.StudentRepository;
import com.example.assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getStudents();
    }

    @GetMapping("/student/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return service.getStudentByName(name);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        return service.deleteStudent(id);
    }

}
