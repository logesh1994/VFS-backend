package com.cognizant.outreach.vfs.dao.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.BusinessUnitRepo;

public class BusinessUnitRepositoryTest extends BaseRepoTest{

	@Autowired
	private BusinessUnitRepository businessUnitRepository;
	
	BusinessUnitRepo buRepo =  null;
	
	@Before
	public void setUp() {
		buRepo = createBuRepo("Test BU", "Test City");
	}
	
	@Test
	public void testFindByBusinessUintId() {
		BusinessUnitRepo repo = businessUnitRepository.findByBusinessUintId(buRepo.getId());
		Assert.assertEquals(buRepo.getId(), repo.getId());
	}
	
	@Test
	public void testFindByBusinessUintName() {
		BusinessUnitRepo repo = businessUnitRepository.findByBusinessUintId(buRepo.getId());
		Assert.assertEquals(buRepo.getBussUnitName(), repo.getBussUnitName());
	}
}
