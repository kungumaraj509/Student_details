package com.example.demo.Controllers;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentService;
import com.example.demo.Models.Student;
@RestController
public class ApiController {
	
	@Autowired
	StudentService studentservice;
	
	
	@GetMapping("/student")
	public List<Student> showStudentDetails(){
		
		return studentservice.getStudentDetails();
	}

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id) {
        try {
            Student student1 = studentservice.get(id);
            studentservice.save(id, student1);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @DeleteMapping("/student/{id}")
    public void delete(@PathVariable Integer id) {
        studentservice.delete(id);
    }
}
