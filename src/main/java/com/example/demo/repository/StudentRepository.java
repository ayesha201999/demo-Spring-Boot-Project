package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.student;

@Repository
public interface StudentRepository extends MongoRepository<student, String>{
	static student findByFirstName(String firstName){
		return null;
	}
    static  student findByUsn(String usn) {
		// TODO Auto-generated method stub
		return null;
	}
}
