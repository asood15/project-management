package com.ashima.pma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashima.pma.dao.ProjectRepository;
import com.ashima.pma.dto.ProjectStageCount;
import com.ashima.pma.entities.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepo;
	
	public List<Project> getAllProjects() {
		return projectRepo.findAll();
	}
	
	public Project saveProject(Project project) {
		return projectRepo.save(project);
	}
	
	public List<ProjectStageCount> getProjectStatusCount() {
		return projectRepo.getProjectStatusCount();
	}
}
