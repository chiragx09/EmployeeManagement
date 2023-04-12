package com.example.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagement.entity.LoginDetails;

@Repository
public interface LoginRepo extends JpaRepository<LoginDetails, Integer>{
	
	public LoginDetails findByUsername(String username);

}
