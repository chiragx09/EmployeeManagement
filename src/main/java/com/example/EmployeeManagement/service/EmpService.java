package com.example.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.repository.EmpRepo;

@Component
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
	}
	
	public List<Employee> getAllEmp(){
		return repo.findAll();
	}
	
	public Employee getEmpById(int id) {
		Optional<Employee> o=repo.findById(id);
		if(o.isPresent()) return o.get();
		else return null;
		
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
