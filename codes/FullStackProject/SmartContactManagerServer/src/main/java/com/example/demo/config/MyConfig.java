package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// WebSecurityConfigurerAdapter is deprecated in newer versions of spring boot 
// so changed dependency according to previous version

@Configuration
@EnableWebSecurity
public class MyConfig {
	
	
	// declaring bean
	@Bean
	public UserDetailsService getUserDetailsService() {
		
		return new UserDetailsServiceImpl();
	}
	
	//Bcrypt password Encoder
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider oDaoAuthenticationProvider = new DaoAuthenticationProvider();
		
		oDaoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		oDaoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return oDaoAuthenticationProvider;
	}

	
	// configure method
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.authenticationProvider(authenticationProvider());
//	}
	
	

//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        		
//	        		auth.authenticationProvider(authenticationProvider());
//	    }
//	
	
//	@Bean
//    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder
//        .userDetailsService(getUserDetailsService()).passwordEncoder(passwordEncoder());
//        return authenticationManagerBuilder.build();
//    }
	
	
//	@Bean 
//	public WebSecurityCustomizer
	
	
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
		
		return configuration.getAuthenticationManager();
	}
	
	
	 @Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

         http.authorizeHttpRequests(requests -> {
			try {
                requests
                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")
                        .requestMatchers("/user/**")
                        .hasRole("USER")
                        .requestMatchers("/home/get").permitAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
         http.authenticationProvider(authenticationProvider());
			return http.build();
		}

}




