package com.example.demo.connection;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	 @Autowired
	 private StudentService studentService;
	 
	 @RequestMapping("/create")
	    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age,@RequestParam int sem, @RequestParam String sec,@RequestParam String usn) {
	        student p = studentService.create(firstName, lastName, age,sem,sec,usn);
	        return p.toString();
	    }
	    @PostMapping(value = "/")
	    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody student person) {
	        studentService.createrecord(person);
	        return new ResponseEntity("Student added successfully", HttpStatus.OK);
	    }

	    
	 @GetMapping(value="/")
	    public List<student> getAll(){
	        return studentService.getAll();
	    }
	    
	    @GetMapping(value="/firstname/{firstName}")
	    public student getstudentbyname(@PathVariable ("firstName") String firstName) {
	        return studentService.getByFirstName(firstName);
	    }
	    @GetMapping(value="/usn/{usn}")
	    public student getstudentbyusn(@PathVariable ("usn") String usn) {
	        return studentService.getByUsn(usn);
	    }
	    
	    @RequestMapping("/update")
	    public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam int sem, @RequestParam String sec,@RequestParam String usn) {
	        student p = studentService.update(firstName, lastName, age,sem,sec,usn);
	        return p.toString();
	    }
	    @PutMapping(value="/{usn}")
	    public student updaterecord(@RequestBody student s, @PathVariable ("usn") String usn) {
	        student p = studentService.updaterecord(s,usn);
	        return p;
	    }
	    @RequestMapping("/delete")
	    public String delete(@RequestParam String firstName) {
	        studentService.delete(firstName);
	        return "Deleted "+firstName;
	    }
	    @DeleteMapping(value="/firstname/{firstName}")
	    public String deleterecord(@PathVariable("firstName") String firstName){
	        studentService.delete(firstName);
	        return "deleted"+firstName;
	    }
	    @DeleteMapping(value="/")
	    public String deleteallrecord() {
	        studentService.deleteAll();
	        return "Deleted all the records from students";
	    }
	    @DeleteMapping(value="/usn/{usn}")
	    public String deletebyusn(@PathVariable("usn") String usn) {
	        studentService.deletebyusn(usn);
	        return "deleted"+usn;
	    }
	    @RequestMapping ("/deleteAll")
	    public String deleteAll() {
	        studentService.deleteAll();
	        return "Deleted all records";
	    }
	   
}
