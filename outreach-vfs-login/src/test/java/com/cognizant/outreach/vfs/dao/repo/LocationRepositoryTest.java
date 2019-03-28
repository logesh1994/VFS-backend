package com.cognizant.outreach.vfs.dao.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.LocationRepo;

public class LocationRepositoryTest extends BaseRepoTest {

	@Autowired
	private LocationRepository locationRepository;
	
	private LocationRepo location = null;
	
	@Before
	public void setUp() {
		location = createLocationRepo("Test City", null, null);
	}
	
	@Test
	public void testFindByLocationId() {
		LocationRepo repo = locationRepository.findByLocationId(location.getId());
		Assert.assertEquals(location.getCity(), repo.getCity());
	}
	
	@Test
	public void testFindByLocationCityName() {
		LocationRepo repo = locationRepository.findByLocationCityName(location.getCity());
		Assert.assertEquals(location.getId(), repo.getId());
	}
	
}
