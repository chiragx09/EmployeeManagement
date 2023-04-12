package com.example.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String serveHit(Model m) {
		return "redirect:home";
	}
	
	@GetMapping("/home")
	public String home(Model m) {
		m.addAttribute("emp",service.getAllEmp() );
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmp() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg", "Employee addes successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Employee e=service.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String update( @ModelAttribute Employee e) {
		service.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/";
	}

}
