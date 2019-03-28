package com.cognizant.outreach.vfs.dao.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.EventCouncilRepo;

public class EventCouncilRepositoryTest extends BaseRepoTest {

	@Autowired
	private EventCouncilRepository councilRepository;
	
	private EventCouncilRepo council = null;
	
	@Before
	public void setUp() {
		council = createEventCouncilRepo();
	}
	
	@Test
	public void testFindByEventCouncilId() {
		EventCouncilRepo repo = councilRepository.findByEventCouncilId(council.getId());
		Assert.assertEquals(council.getCouncilName(), repo.getCouncilName());
	}
	
	@Test
	public void testFindByEventCouncilName() {
		EventCouncilRepo repo = councilRepository.findByEventCouncilName(council.getCouncilName());
		Assert.assertEquals(council.getId(), repo.getId());
	}
}
