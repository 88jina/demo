package com.example.assignment.repository;

import com.example.assignment.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);
    List<Student> findByNameContaining(@Param("name") String name, Sort by);
}
