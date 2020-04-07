package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//Document annotation
@Document(collection="student")
public class student {
	@Id
    String id;
    String firstName;
    String lastName;
    int age;
    int sem;
    String sec;
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

