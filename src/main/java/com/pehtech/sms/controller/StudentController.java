package com.pehtech.sms.controller;

import com.pehtech.sms.model.Student;
import com.pehtech.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/students/student/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
