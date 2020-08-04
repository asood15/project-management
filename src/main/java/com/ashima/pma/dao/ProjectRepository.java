package com.ashima.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ashima.pma.dto.ProjectStageCount;
import com.ashima.pma.dto.TimeChartData;
import com.ashima.pma.entities.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>{

	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value="SELECT stage as label, count(STAGE) as value FROM PROJECT GROUP BY STAGE")
	public List<ProjectStageCount> getProjectStatusCount();
	
	@Query(nativeQuery = true, value= "SELECT name as projectName, start_date as startDate, end_date as endDate "
			+ "FROM PROJECT WHERE START_DATE IS NOT NULL")
	public List<TimeChartData> getTimeData();
}
