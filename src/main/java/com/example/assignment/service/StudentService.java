package com.example.assignment.service;

import com.example.assignment.entity.Student;
import com.example.assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
    }

    public Student getStudentById(long id){
        return studentRepository.findById(id).orElse(null);
    }

    /*public Student getStudentByName(String name){
        return studentRepository.findByName(name);
    }
*/

    public List<Student> getStudentsByName(String name){
        return studentRepository.findByNameContaining(name, Sort.by(Sort.Direction.ASC,"name"));
    }
    public String deleteStudent(long id){
        studentRepository.deleteById(id);
        return id+"student removed";
    }

    public Student updateStudent(Student student){
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setSchool(student.getSchool());
        existingStudent.setMajor(student.getMajor());
        existingStudent.setAddr(student.getAddr());
        studentRepository.save(existingStudent);
        return existingStudent;
    }




}
