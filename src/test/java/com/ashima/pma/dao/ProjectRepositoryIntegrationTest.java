package com.ashima.pma.dao;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.ashima.pma.entities.Project;

@SpringBootTest
@RunWith(SpringRunner.class)
// for running some sql files before and after test execution, else data will not load	

@SqlGroup({@Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql","classpath:data.sql"}),
	@Sql(executionPhase=ExecutionPhase.AFTER_TEST_METHOD, scripts="classpath:drop.sql")})
public class ProjectRepositoryIntegrationTest {

	@Autowired 
	ProjectRepository proRepo;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("New Test Project", "COMPLETE", "Testing...");
		proRepo.save(newProject);
		
		assertEquals(5, proRepo.findAll().size());
	}
	
}
