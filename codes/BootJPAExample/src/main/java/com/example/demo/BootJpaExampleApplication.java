package com.example.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Users1;
//import com.example.demo.repository.UserRepo;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
//		ApplicationContext context= 
		SpringApplication.run(BootJpaExampleApplication.class, args);
		
//		UserRepo uR = (UserRepo) context.getBean(UserRepo.class);
//		
//		Users1 u = new Users1();
//		u.setUserid(1l);
//		u.setUsername("Devarshi");
//		u.setPassword("1234");
		
//		Users1 savedUser = uR.save(u);
		
//		System.out.println(savedUser);
		
		// Update
//		Optional<Users1> opt = uR.findById(1l);
//		
//		Users1 u1 = opt.get();
//		System.out.println(u1);
//		
//		u1.setUserid(1l);
//		u1.setUsername("Devarshi");
//		u1.setPassword("12345");
//		
//		Users1 savedUser = uR.save(u1);
//		
//		System.out.println(savedUser);
		
		
	}

}
