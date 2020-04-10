package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	   @Autowired
	    private StudentRepository studentRepository;
	   
	public student create(String firstName,String lastName, int age ,int sem, String sec,String usn) {
       
		return studentRepository.save(new student(firstName, lastName, age,sem,sec,usn));
	}
            
	
    //Retrieve operation
    public List<student> getAll(){
        return studentRepository.findAll();
    }
    public student getByFirstName(String firstName) {
        return StudentRepository.findByFirstName(firstName);
    }

    public student getByUsn(String usn) {
        return StudentRepository.findByUsn(usn);
    }
    //Update operation
    public student update(String firstName, String lastName, int age,int sem, String sec, String usn) {
        student p = StudentRepository.findByFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        p.setUsn(usn);
        p.setSem(sem);
        p.setSec(sec);
        return studentRepository.save(p);
    }
    public student updaterecord(student s, String usn) {
        student p = StudentRepository.findByUsn(usn);
        p.setFirstName(s.getFirstName());
        p.setLastName(s.getLastName());
        p.setAge(s.getAge());
        p.setSec(s.getSec());
        p.setSem(s.getSem());
        studentRepository.save(p);
        return p;

    }
    //Delete operation
    public void deleteAll() {
        studentRepository.deleteAll();
    }
    public void delete(String firstName) {
        student p = StudentRepository.findByFirstName(firstName);
        studentRepository.delete(p);
    }
    public void deletebyusn(String usn) {
        student s =StudentRepository.findByUsn(usn);
        studentRepository.delete(s);
        
    }
    public  student createrecord(student person) {
        studentRepository.save(person);
        return person;
    }

}
