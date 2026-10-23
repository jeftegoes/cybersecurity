package com.example.controllers;

import com.example.models.Student;
import com.example.repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // http://localhost:8080/api/students/age?age=20
    // http://localhost:8080/api/students/age?age=10 or 1=1
    @GetMapping("/age")
    public List<Student> findByAge(@RequestParam String age) {

        return repository.findByAge(age);
    }
}
