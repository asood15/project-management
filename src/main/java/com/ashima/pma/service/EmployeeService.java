package com.ashima.pma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ashima.pma.dao.EmployeeRepository;

@Service
public class EmployeeService {

//	// field injection
//	@Autowired
//	EmployeeRepository empRepo1;
//	
//	// constructor injection
//	EmployeeRepository empRepo2;
//	public EmployeeService(EmployeeRepository empRepo) {
//		this.empRepo2 = empRepo;
//	}
//	
//	// setter injection
//	EmployeeRepository empRepo3;
//	@Autowired
//	public void setEmpRepo3(EmployeeRepository empRepo3) {
//		this.empRepo3 = empRepo3;
//	}
	
	@Autowired
	@Qualifier("staffRepoImpl1")
	StaffRepo repo;
	
}
