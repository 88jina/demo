package com.example.assignment.controller;

import com.example.assignment.entity.Student;
import com.example.assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jmx.export.metadata.ManagedOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.List;

@RestController

public class StudentController {

    @Autowired
    private StudentService service;

    //전체 학생리스트
    @GetMapping("/students")
    public ModelAndView getAllStudents() {
        List<Student> students = service.getStudents();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("students", students);
        return mv;
    }


    //add new student page
    @GetMapping("/adding")
    public ModelAndView addPage(){
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }
    //학생 신규 입력
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView addStudent(Student student) {
        service.saveStudent(student);
        ModelAndView mv = new ModelAndView("alert");
        mv.addObject("msg","Registered Successfully");
        return mv;
    }

    //이름으로 검색
    @GetMapping("/student")
    public ModelAndView getStudentsByName(@RequestParam("name") String name) {
        List<Student> students = service.getStudentsByName(name);
        if (students.size() != 0) {
            ModelAndView mv = new ModelAndView("found");
            mv.addObject("students", students);
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("alert");
            mv.addObject("msg", "No Result, Please add the data");
            return mv;
        }

    }

    @GetMapping("/student/{id}")
    public ModelAndView getStudentById(@PathVariable long id) {
        ModelAndView mv = new ModelAndView("info");
        Student student = service.getStudentById(id);
        mv.addObject("student", student);
        return mv;
    }

    //학생 정보 수정 페이지로 가기
    @GetMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable long id) {
        ModelAndView mv = new ModelAndView("update");
        Student student = service.getStudentById(id);
        mv.addObject("student", student);
        return mv;
    }

    //학생 정보 수정
    @PostMapping(value = "/edit", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView updateStudent(Student student) {
        service.updateStudent(student);
        String msg = "Edited Successfully";
        ModelAndView mv = new ModelAndView("alert");
        mv.addObject("msg", msg);
        return mv;
    }

    //학생 정보 삭제
    @PostMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable long id) {
        service.deleteStudent(id);
        ModelAndView mv = new ModelAndView("alert");
        String msg = "Deleted Succesfully";
        mv.addObject("msg", msg);
        return mv;
    }

}
