package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@GetMapping(value="/get1")
	public List<Student> getAllStudents(){
		System.out.println("get api");
		return studentRepo.findAll();
	}
	
	@GetMapping(value="/get2")
	public String getAll(){
		System.out.println("get api2");
		return "api 2";
	}
	
	@GetMapping(value="/save")
	private Student saveStudent(@RequestBody Student student) {
		System.out.println("save api");
		return studentRepo.save(student);
	}

}
