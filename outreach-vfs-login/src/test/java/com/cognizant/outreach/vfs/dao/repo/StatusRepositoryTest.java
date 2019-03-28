package com.cognizant.outreach.vfs.dao.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.StatusRepo;

public class StatusRepositoryTest extends BaseRepoTest {

	@Autowired
	private StatusRepository statusRepository;
	
	private StatusRepo statusRepo;
	
	@Before
	public void setUp() {
		statusRepo = createStatusRepo("Test Status");
	}
	
	@Test
	public void testFindByStatusId() {
		StatusRepo repo = statusRepository.findByStatusId(statusRepo.getId());
		Assert.assertEquals(statusRepo.getDescription(), repo.getDescription());
	}
	
	@Test
	public void testFindByStatusDescription() {
		StatusRepo repo = statusRepository.findByStatusDescription(statusRepo.getDescription());
		Assert.assertEquals(statusRepo.getId(), repo.getId());
	}
}
