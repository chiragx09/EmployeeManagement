package com.example.EmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagement.entity.LoginDetails;
import com.example.EmployeeManagement.entity.CustomLoginDetails;
import com.example.EmployeeManagement.repository.LoginRepo;

@Service
public class CustomLoginDetailsService  implements UserDetailsService{
	
	@Autowired
	private LoginRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LoginDetails user=this.repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new CustomLoginDetails(user);
	}

}
