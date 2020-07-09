package com.ashima.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashima.pma.dao.EmployeeRepository;
import com.ashima.pma.dao.ProjectRepository;
import com.ashima.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		model.addAttribute("project", new Project());
		model.addAttribute("allEmployees", empRepo.findAll());
		return "projects/new-project";
	}
	
	@PostMapping(path="/save")
	public String createProject(Project project) {
		System.out.println("In save...");
		projectRepo.save(project);
		
		/*
		 * System.out.println(employeeIds.get(0)); for (String empId : employeeIds) {
		 * Long id = Long.getLong(empId); Employee e = empRepo.findById(id).get();
		 * e.setProjects(project); empRepo.save(e); }
		 */
		
		/*
		 * Iterable<Employee> emps = empRepo.findAllById(employees); for (Employee emp:
		 * emps) { emp.setProjects(project); empRepo.save(emp); }
		 */
		return "redirect:/projects";
	}
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
}
