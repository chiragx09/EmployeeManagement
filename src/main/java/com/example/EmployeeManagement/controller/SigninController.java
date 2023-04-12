package com.example.EmployeeManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {
	
	@RequestMapping("/signin")
	public String signin() {
		System.out.println("in sign in controller");
		return "signin";
	}

}
