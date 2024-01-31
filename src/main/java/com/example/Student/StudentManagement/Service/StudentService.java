package com.example.Student.StudentManagement.Service;

import com.example.Student.StudentManagement.Entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);
    Student update(Student student);

    void deleteStudentById(Long id);
}
