package com.example.Student.StudentManagement.Repository;

import com.example.Student.StudentManagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
