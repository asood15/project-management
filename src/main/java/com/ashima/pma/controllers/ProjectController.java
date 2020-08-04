package com.ashima.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashima.pma.dto.TimeChartData;
import com.ashima.pma.entities.Employee;
import com.ashima.pma.entities.Project;
import com.ashima.pma.service.EmployeeService;
import com.ashima.pma.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public String createProject(Model model, @Valid Project project, Errors errors) {
		if (errors.hasErrors()) {
			model.addAttribute("allEmployees", empService.getEmployees());
			return "projects/new-project";
		}
		projectService.saveProject(project);
		return "redirect:/projects";
	}
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectService.getAllProjects();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/timelines")
	public String displayProjectTimelines(Model model) throws JsonProcessingException {
		List<TimeChartData> timelines = projectService.getTimeData();
		
		ObjectMapper objMapper =  new ObjectMapper();
		String jsonTimeline = objMapper.writeValueAsString(timelines);
		
		model.addAttribute("projectTimeList", jsonTimeline);
		return "projects/project-timelines";
	}
	
	@GetMapping("/update/{id}")
	public String updateProject(Model model, @PathVariable long id) {
		Project project = projectService.getProject(id);
		model.addAttribute("allEmployees", empService.getEmployees());
		model.addAttribute("project", project);
		return "projects/new-project";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProject(Model model, @PathVariable long id) {
		 projectService.deleteProject(id);
		 return "redirect:/projects";
	}
	
}
