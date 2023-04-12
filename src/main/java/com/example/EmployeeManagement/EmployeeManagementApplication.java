package com.example.EmployeeManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.EmployeeManagement.entity.LoginDetails;
import com.example.EmployeeManagement.repository.LoginRepo;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner{
	
	@Autowired
	private LoginRepo repo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LoginDetails ad= new LoginDetails();
		ad.setUsername("admin");
		ad.setRoll("ROLE_ADMIN");
		ad.setPassword(this.encoder.encode("ram"));
		this.repo.save(ad);
		
	}

}
