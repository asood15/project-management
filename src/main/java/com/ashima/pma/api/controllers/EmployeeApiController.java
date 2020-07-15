package com.ashima.pma.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ashima.pma.entities.Employee;
import com.ashima.pma.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApiController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return empService.getEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return empService.getEmployee(id);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee( @RequestBody @Valid Employee emp) {
		return empService.saveEmployee(emp);
	}
	
	@PutMapping(value = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee updateEmployee(@PathVariable String id, @RequestBody @Valid Employee emp) {
		System.out.println(id);
		return empService.saveEmployee(emp);
	}
	
	
	@PatchMapping(value = "/{id}", consumes = "application/json")
	public Employee patchEmployee(@PathVariable long id, @RequestBody @Valid Employee emp) {
		return empService.patchProject(id, emp);
	}
	
	@DeleteMapping(value = "/{id}")
	public boolean deleteEmployee(@PathVariable long id) {
		return empService.deleteEmployee(id);
	}
	
	@GetMapping(params= {"page", "size"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable	<Employee> findPaginatedEmployees(@RequestParam("page") int page,
			@RequestParam("size") int size) {
		Pageable pageAndSize = PageRequest.of(page, size);
		return empService.getPaginatedEmployees(pageAndSize);
	}
}
