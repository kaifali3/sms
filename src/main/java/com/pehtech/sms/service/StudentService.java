package com.pehtech.sms.service;

import com.pehtech.sms.model.Student;
import com.pehtech.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        //this will return list of students
        return studentRepository.findAll();
    }

    public Student getStudent(int id) {
        //this will return one student based one provided id
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
