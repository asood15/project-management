package com.ashima.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ashima.pma.dto.ProjectStageCount;
import com.ashima.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{

	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value="SELECT stage as label, count(STAGE) as value FROM PROJECT GROUP BY STAGE")
	public List<ProjectStageCount> getProjectStatusCount();
}
