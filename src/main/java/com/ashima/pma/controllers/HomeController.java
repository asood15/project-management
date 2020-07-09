package com.ashima.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashima.pma.dao.EmployeeRepository;
import com.ashima.pma.dao.ProjectRepository;
import com.ashima.pma.dto.EmployeeProject;
import com.ashima.pma.dto.ProjectStageCount;
import com.ashima.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	 
	@Value("${version}")
	private String version;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		Map<String, Object> map =  new HashMap<>();
		model.addAttribute("version", version);
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		List<ProjectStageCount> projectStageCount = proRepo.getProjectStatusCount();
		//converting to json
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString = objMapper.writeValueAsString(projectStageCount);
		model.addAttribute("projectStatusCnt", jsonString);
		
		List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
		model.addAttribute("employeesProjectCnt", employeesProjectCnt);
		
		
		
		
		model.addAttribute("projectStageCount", projectStageCount);
		return "home/home";
	}
}
