package com.facundoduarte.mvc.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Student;
import com.facundoduarte.mvc.mvc.repositories.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student s) {
        return studentRepository.save(s);
    }

    public List<Student> allStudents() {
        return studentRepository.findAll();
    }
}
