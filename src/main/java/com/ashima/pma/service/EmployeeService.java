package com.ashima.pma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashima.pma.dao.EmployeeRepository;
import com.ashima.pma.dto.EmployeeProject;
import com.ashima.pma.entities.Employee;

@Service
public class EmployeeService {

	@Autowired 
	EmployeeRepository empRepo;
	
	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}
	
	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	
	public List<EmployeeProject> getEmployeeProjects() {
		return empRepo.employeeProjects();
	}
}
