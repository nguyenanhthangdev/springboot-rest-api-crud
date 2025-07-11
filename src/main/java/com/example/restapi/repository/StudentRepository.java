package com.example.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
