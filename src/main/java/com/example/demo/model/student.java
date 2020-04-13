package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.Id;
//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.exception.StudentNotFoundException;

//Document annotation
@Document(collection="student")
@Entity
public class student {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	
    String id;
	@NotBlank(message = "FirstName is mandatory")
	@Size(min=2, max=30, message="Length of FirstName is too long or too short")
    String firstName;
	@NotBlank(message = "LastName is mandatory")
	@Size(min=2, max=30, message="Length of last name is too long or too short")
    String lastName;

	
	@Min(18)
    int age;
	@Min(1)
	@Max(8)
    int sem;
    @NotBlank(message = "Section is mandatory")
    @Size(min=1, max=2, message="Length of section is too long or too short")
    String sec;
    @NotBlank(message = "USN is mandatory")
    @Size(min=10, max=10,message="Length of USN should be 10")
    String usn;


public student(String firstName,String lastName,int age,int sem,String sec,String usn)
{
    this.firstName=firstName;
    this.lastName=lastName;
	this.age=age;
    this.sem=sem;
    this.sec=sec;
    this.usn=usn; 
}
public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

public int getSem() {
    return sem;
}

public void setSem(int sem) {
    this.sem = sem;
}

public String getSec() {
    return sec;
}

public void setSec(String sec) {
    this.sec = sec;
}

public String getUsn() {
    return usn;
}

public void setUsn(String usn) {
    this.usn = usn;
}

public String toString() {
    return "Person First Name:"+firstName+" Last Name:"+lastName+" age:"+age+"sem"+sem+"sec"+sec+"usn"+usn;
}

}

