package com.example.assignment.controller;

import com.example.assignment.entity.Student;
import com.example.assignment.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    StudentRepository repository;

/*
    @Test
    public void add() throws Exception {

        mvc.perform(post("/add"))
        .andExpect(status().isOk());
        Student newStudent = new Student();
        newStudent.setName("testName");
        newStudent.setAddr("testAddr");
        newStudent.setMajor("testMajor");
        newStudent.setSchool("testSchool");

        repository.save(newStudent);
*/




}
