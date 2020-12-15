package com.example.assignment.controller;

import com.example.assignment.entity.Student;
import com.example.assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping("/add")
    public Student add(Student student){
        Student newStudent = repository.save(student);
        return newStudent;
    }

}
