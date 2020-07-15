package com.ashima.pma.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ashima.pma.dao.EmployeeRepository;
import com.ashima.pma.entities.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String>{

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Employee emp = empRepo.findByEmail(value);
		if(emp != null)
			return false;
		else
			return true;
	}

}
