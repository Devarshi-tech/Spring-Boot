package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.helper.Message;
import com.example.demo.models.Users;
import com.example.demo.repositories.UserRepository;

@Service
public class HomeService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private Message message = new Message();

	
	private ModelMapper modelMapper = new ModelMapper();
	
	/**
	 * Registration Service for user
	 * @param user
	 * @return
	 */
	public ResponseEntity<UserDto> registerUser(Users user){
		
		UserDto userDto = new UserDto();
		
//		setting default role 
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		try {
			user = userRepo.save(user);
			
//			Map returned User model into Dto
			userDto = this.modelMapper.map(user, UserDto.class);
			message.setContent("Saved successfuly");
			userDto.setMessage(message);
			return new ResponseEntity<>(userDto,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			message.setContent("something is duplicate");
			userDto.setMessage(message);
		}
		
		message.setContent("error!! could not invoke save");
		userDto.setMessage(message);
		return new ResponseEntity<>(userDto,HttpStatus.NOT_FOUND);
	}

	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}
