package com.ashima.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashima.pma.entities.Project;
import com.ashima.pma.service.EmployeeService;
import com.ashima.pma.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		model.addAttribute("project", new Project());
		model.addAttribute("allEmployees", empService.getEmployees());
		return "projects/new-project";
	}
	
	@PostMapping(path="/save")
	public String createProject(Project project) {
		projectService.saveProject(project);
		return "redirect:/projects";
	}
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectService.getAllProjects();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
}
