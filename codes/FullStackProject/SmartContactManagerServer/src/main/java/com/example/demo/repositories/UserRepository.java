package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users , Integer>{
	
	@Query("select u from Users u where u.email=:email")
	public Users getUserByUserName(@Param("email") String email);

}
