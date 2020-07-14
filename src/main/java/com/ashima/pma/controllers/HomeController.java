package com.ashima.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashima.pma.dto.EmployeeProject;
import com.ashima.pma.dto.ProjectStageCount;
import com.ashima.pma.entities.Project;
import com.ashima.pma.service.EmployeeService;
import com.ashima.pma.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	@Autowired
	ProjectService projectService;
	@Autowired
	EmployeeService employeeService;
	 
	@Value("${version}")
	private String version;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
			model.addAttribute("version", version);
		List<Project> projects = projectService.getAllProjects();
		model.addAttribute("projects", projects);
		
		List<ProjectStageCount> projectStageCount = projectService.getProjectStatusCount();
		//converting to json
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString = objMapper.writeValueAsString(projectStageCount);
		model.addAttribute("projectStatusCnt", jsonString);
		
		List<EmployeeProject> employeesProjectCnt = employeeService.getEmployeeProjects();
		model.addAttribute("employeesProjectCnt", employeesProjectCnt);
		
		
		
		
		model.addAttribute("projectStageCount", projectStageCount);
		return "home/home";
	}
}
