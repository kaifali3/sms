package com.pehtech.sms.service;

import com.pehtech.sms.model.Student;
import com.pehtech.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private static Map<Integer, Student> studentMap = new HashMap<>();

    public List<Student> getStudents() {
        if (!studentMap.isEmpty()) {
            return new ArrayList<>(studentMap.values());
        }

        List<Student> allStudents = studentRepository.findAll();

        for (Student student : allStudents) {
            studentMap.put(student.getId(), student);
        }

        return allStudents;
    }

    public Student getStudent(int id) {
        if (studentMap.containsKey(id)) {
            return studentMap.get(id);
        } else {
            Optional<Student> optional = studentRepository.findById(id);
            if (optional.isPresent()) {
                Student student = optional.get();
                studentMap.put(student.getId(), student);
                return student;
//                return optional.orElse(null);
            }
            return null;
        }
    }


    public Student createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);

        if (studentMap.isEmpty()) {
            List<Student> allStudents = studentRepository.findAll();
            for (Student studentFromDB : allStudents) {
                studentMap.put(studentFromDB.getId(), studentFromDB);
            }
        } else {
            studentMap.put(savedStudent.getId(), savedStudent);
        }

        return savedStudent;
    }
}
