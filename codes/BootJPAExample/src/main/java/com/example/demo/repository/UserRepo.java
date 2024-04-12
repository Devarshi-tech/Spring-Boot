package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users1;

@Repository
public interface UserRepo extends JpaRepository<Users1,Integer>{

}
