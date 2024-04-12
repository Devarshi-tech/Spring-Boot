package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.models.Users;
import com.example.demo.repositories.UserRepository;

public class UserDetailsServiceImpl implements
 UserDetailsService{
	@Autowired
	private UserRepository userRepo;
	
	/**
	 * @param username (email)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Fetch user from database
		Users user = userRepo.getUserByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("Could not find user details");
		}		
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		
		return customUserDetails;
	}
	
	

}