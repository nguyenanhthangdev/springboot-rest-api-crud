package com.example.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.entity.Student;
import com.example.restapi.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {
    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student create(@RequestBody Student s) {
        return studentRepository.save(s);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getOne(@PathVariable Long id) {
        return studentRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student s) {
        return studentRepository.findById(id).map(old ->{
            old.setName(s.getName());
            old.setEmail(s.getEmail());
            old.setMajor(s.getMajor());
            return ResponseEntity.ok(studentRepository.save(old));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
