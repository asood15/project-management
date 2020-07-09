package com.ashima.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashima.pma.dao.EmployeeRepository;
import com.ashima.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("/new")
	public String createNewEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String saveNewEmployee(Model model, Employee employee) {
		employeeRepo.save(employee);
		return "redirect:/employees/new";
	}
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = employeeRepo.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
}
