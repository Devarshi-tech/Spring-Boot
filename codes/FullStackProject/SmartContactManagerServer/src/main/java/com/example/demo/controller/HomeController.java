package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.helper.Message;
import com.example.demo.models.Users;
import com.example.demo.service.HomeService;

import jakarta.validation.Valid;

//import jakarta.validation.Valid;


//@Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController("/home")

public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	private Message message = new Message();
	
//	@PostMapping("/home")
//	public String home() {
//		
//		return "home";
//	}
	
	@PostMapping("/registerUser")
	public ResponseEntity<UserDto> registerUser(@RequestBody @Valid Users user
			,BindingResult result) {
		UserDto userDto = new UserDto(); 
		
		// server side validation for name and email
		if(result.hasErrors()) {
			
			message.setContent(
					result.hasFieldErrors("name")? "Please Enter Name!!" : "Please Enter Valid Mail Address!!"
					);
			userDto.setMessage(message);
			return new ResponseEntity<>(userDto,HttpStatus.OK);
		}
		
		try {
			return homeService.registerUser(user);
		}
		catch(Exception e) {
			e.printStackTrace();
			message.setContent("Something went wrong");
			userDto.setMessage(message);
		}
		
		return new ResponseEntity<>(userDto,HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/get")
	public List<Users> getAllUsers(){
		System.out.print("get All users api hit");
		return homeService.findAll();
	}

}
