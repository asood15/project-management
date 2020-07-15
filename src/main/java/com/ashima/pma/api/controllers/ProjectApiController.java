package com.ashima.pma.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ashima.pma.entities.Project;
import com.ashima.pma.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectApiController {

	@Autowired
	ProjectService proService;
	
	@GetMapping
	public List<Project> getAllProjects() {
		return proService.getAllProjects();
	}
	
	@GetMapping("/{id}")
	public Project getProjectById(@PathVariable long id) {
		return proService.getProject(id);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Project createProject( @RequestBody @Valid Project project) {
		return proService.saveProject(project);
	}
	
	@PutMapping(value = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Project updateProject(@PathVariable String id, @RequestBody @Valid Project project) {
		return proService.updateProject(project);
	}
	
	@PatchMapping(value = "/{id}", consumes = "application/json")
	public Project patchProject(@PathVariable long id, @RequestBody @Valid Project project) {
		return proService.patchProject(id, project);
	}
	
	@DeleteMapping(value = "/{id}")
	public boolean deleteProject(@PathVariable long id) {
		return proService.deleteProject(id);
	}
}
