package com.ashima.pma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Employee getEmployee(long id) {
		return empRepo.findById(id).get();
	}
	
	public Employee updateProject(Employee emp) {
		return empRepo.save(emp);
	}
	
	public Employee patchProject(long id, Employee emp) {
		Employee e = getEmployee(id);
		if (e != null) {
			if (emp.getFirstName() != null) {
				e.setFirstName(emp.getFirstName());
			} else if (emp.getLastName() != null) {
				e.setFirstName(emp.getLastName());
			} else if (emp.getEmail() != null) {
				e.setFirstName(emp.getEmail());
			}
			return empRepo.save(e);
		} else {
			System.out.println("Error occurred, no employee found with id " + id);
			return null;
		}
	}
	
	
	public boolean deleteEmployee(long id) {
		 try {
			 empRepo.deleteById(id);
			 return true;
		 } catch (Exception e) {
			 System.out.println("Error occurred, no employee found with id " + id);
			 return false;
		 }
	}
	
	public Page<Employee> getPaginatedEmployees(Pageable pageable) {
		return empRepo.findAll(pageable);
	}
}
