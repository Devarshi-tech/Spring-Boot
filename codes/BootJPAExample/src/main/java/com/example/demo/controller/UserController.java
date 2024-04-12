package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.model.Users1;
import com.example.demo.repository.UserRepo;

//@Controller
@RestController 
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@GetMapping(value="/getUsers")
//	@ResponseBody
	public List<Users1> getUsers() {
		Users1 u1 = new Users1();
		
		List<Users1> u2 =(List<Users1>) userRepo.findAll();
		
		return u2;
	}
	
	@PostMapping(value="/setUser",produces="Application/json")
	public Users1 setUser(@RequestBody Users1 user1) {
//		 = new Users1();
		
//		Department dep = new Department();
//		dep.setDpname("It");
//		user1.setDepartment(dep);

		 Users1 user = userRepo.save(user1);
		 
		return user;
	}
	
	@DeleteMapping(value="/delete")
	public String deleteUser(@RequestHeader("id") Integer id) {
		Users1 u1 = new Users1();

		Optional<Users1> op = userRepo.findById(id);
		u1 = op.get();
		userRepo.delete(u1);
		return "Deleted Successfully";
	}

}
