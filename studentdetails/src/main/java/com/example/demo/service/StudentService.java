package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentService {

	@Autowired
	StudentRepository studentrepo;
	
	public List<Student> getStudentDetails()
	{
		return studentrepo.findAll();
	}
	
	public void save(int id, Student student)
	{
		studentrepo.saveAndFlush(student);
	}
	
	 public void delete(Integer id) {
	        studentrepo.deleteById(id);
	    }
	   public Student get(Integer id) {
	        return studentrepo.findById(id).get();
	    }
	
}
