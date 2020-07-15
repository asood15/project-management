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
	
	public Project getProject(long id) {
		return projectRepo.findById(id).get();
	}
	
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
	
	public Project patchProject(long id, Project project) {
		Project p = getProject(id);
		if (p != null) {
			if (project.getName() != null) {
				p.setName(project.getName());
			} else if (project.getDescription() != null) {
				p.setName(project.getDescription());
			} else if (project.getStage() != null) {
				p.setName(project.getStage());
			}
			return projectRepo.save(project);
		} else {
			System.out.println("Error occurred, no project found with id " + id);
			return null;
		}
	}
	
	
	public boolean deleteProject(long id) {
		 try {
			 projectRepo.deleteById(id);
			 return true;
		 } catch (Exception e) {
			 System.out.println("Error occurred, no project found with id " + id);
			 return false;
		 }
	}
}
