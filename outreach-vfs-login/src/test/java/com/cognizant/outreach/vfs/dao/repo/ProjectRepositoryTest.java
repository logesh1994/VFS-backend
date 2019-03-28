package com.cognizant.outreach.vfs.dao.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.ProjectRepo;

public class ProjectRepositoryTest extends BaseRepoTest{

	@Autowired
	private ProjectRepository projectRepository;
	
	private ProjectRepo project = null;
	
	@Before
	public void setUp() {
		project = createProjectRepo("Test Project");
	}
	
	@Test
	public void testFindByProjectId() {
		ProjectRepo repo = projectRepository.findByProjectId(project.getId());
		Assert.assertEquals(project.getDescription(), repo.getDescription());
	}
	
	@Test
	public void testFindByProjectDescription() {
		ProjectRepo repo = projectRepository.findByProjectDescription(project.getDescription());
		Assert.assertEquals(project.getId(), repo.getId());
	}
	
}
