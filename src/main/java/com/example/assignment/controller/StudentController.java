package com.example.assignment.controller;

import com.example.assignment.entity.Student;
import com.example.assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    //학생 신규 입력
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    //전체 학생리스트
    @GetMapping("/students")
    public void getAllStudents() {
        List<Student> students = service.getStudents();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("students", students);

    }

    //이름으로 검색
    @GetMapping("/student/{name}")
    public void getStudentByName(@PathVariable String name) {
        Student student = service.getStudentByName(name);
        ModelAndView mv = new ModelAndView("info");
        mv.addObject("student",student);
    }

    //학생 정보 수정 페이지로 가기
    @GetMapping("/update/{id}")
    public void updatePage(@PathVariable long id, ModelAndView mv){
        mv.setViewName("update");
        Student student = service.getStudentById(id);
        mv.addObject("student",student);
    }

    //학생 정보 수정
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    //학생 정보 삭제
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        return service.deleteStudent(id);
    }

}
