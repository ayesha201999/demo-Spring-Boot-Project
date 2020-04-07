package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.student;

@Repository
public interface StudentRepository extends MongoRepository<student, String>{
    student findByFirstName(String firstName);
    student findByUsn(String usn);
}
