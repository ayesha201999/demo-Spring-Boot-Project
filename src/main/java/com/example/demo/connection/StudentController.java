package com.example.demo.connection;

import java.util.List;
import java.util.*;

import javax.validation.Valid;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
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

import com.example.demo.exception.CustomizedResponseEntityExceptionHandler;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.student;
import com.example.demo.model.student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;


@RestController
public class StudentController {
	 @Autowired
	 private StudentService studentService;	
	 @RequestMapping("/create")
	    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age,@RequestParam int sem, @RequestParam String sec,@RequestParam String usn) {
		 if (firstName==null||lastName==null||((age==0)||(age<0))||sec==null||((sem==0)||(sem<0))||sec==null||usn==null)
	        {
			 throw new StudentNotFoundException("Incomplete information");
	        }
		 student p = studentService.create(firstName, lastName, age,sem,sec,usn);
	        return p.toString();
	        
	 }
	 
	    @PostMapping(value = "/")
	    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody student person) {
	        studentService.createrecord(person);
	        return new ResponseEntity("Student added successfully", HttpStatus.OK);
	       /*
	       if (firstName==null||lastName==null||((age==0)||(age<0))||sec==null||((sem==0)||(sem<0))||sec==null||usn==null)
	        {
				return new ResponseEntity("Incomplete information/wrong information ", HttpStatus.NOT_FOUND);
	        }
	        */
	       
	        
	    }

	    
	 @GetMapping(value="/")
	    public List<student> getAll(){
	        return studentService.getAll();
	    }
	    
	    @GetMapping(value="/firstname/{firstName}")
	    public student getstudentbyname(@PathVariable ("firstName") String firstName) {
	    student s=studentService.getByFirstName(firstName);
	    		if (s==null)
			throw new StudentNotFoundException(firstName+" is not Found");
	        return studentService.getByFirstName(firstName);
	    }
	    @GetMapping(value="/usn/{usn}")
	    public student  getstudentbyusn(@PathVariable ("usn") String usn) {
	    	student s = StudentRepository.findByUsn(usn);
	    	if (s==null)
				throw new StudentNotFoundException(usn + " is not present");

	        return studentService.getByUsn(usn);
	    }
	    
	    @RequestMapping("/update")
	    public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam int sem, @RequestParam String sec,@RequestParam String usn) {
	        student p = studentService.update(firstName, lastName, age,sem,sec,usn);
	        return p.toString();
	    }
	    @PutMapping(value="/{usn}")
	    public ResponseEntity<student>  updaterecord(@RequestBody student s, @PathVariable ("usn") String usn) {
	    	student studentOptional = StudentRepository.findByUsn(usn);
	    	if (studentOptional==null)
				return new ResponseEntity("FAILED TO UPDATE ", HttpStatus.NOT_FOUND);


	    	studentService.updaterecord(s,usn);
	    	
	    	return new ResponseEntity("UPDATED SUCCESSFULLY", HttpStatus.OK);
	    }
	    @RequestMapping("/delete")
	    public String delete(@RequestParam String firstName) {
	        studentService.delete(firstName);
	        return "Deleted "+firstName;
	    }
	    @DeleteMapping(value="/firstname/{firstName}")
	    public String deleterecord(@PathVariable("firstName") String firstName){
	    	student s = StudentRepository.findByFirstName(firstName);
	    	if (s==null)
				throw new StudentNotFoundException(  " is not present"+firstName);
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
	    	student s = StudentRepository.findByUsn(usn);
	    	if (s==null)
				throw new StudentNotFoundException(usn + " is not present");
	        studentService.deletebyusn(usn);
	        return "deleted"+usn;
	    }
	    @RequestMapping ("/deleteAll")
	    public String deleteAll() {
	        studentService.deleteAll();
	        return "Deleted all records";
	    }
	 
	 
	
	 
}
