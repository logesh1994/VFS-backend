package com.cognizant.outreach.vfs.dao.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.EventBeneficiaryRepo;

public class EventBeneficiaryRepositoryTest extends BaseRepoTest {

	@Autowired
	private EventBeneficiaryRepository beneficiaryRepository;
	
	private EventBeneficiaryRepo beneficiaryRepo = null;
	
	@Before
	public void setUp() {
		beneficiaryRepo = createBenificiaryRepo("Test Beneficiary");
	}
	
	@Test
	public void testFindByEventBeneficiaryId() {
		EventBeneficiaryRepo repo = beneficiaryRepository.findByEventBeneficiaryId(beneficiaryRepo.getId());
		Assert.assertEquals(beneficiaryRepo.getDescription(), repo.getDescription());
	}
	
	@Test
	public void testFindByEventBeneficiaryName() {
		EventBeneficiaryRepo repo = beneficiaryRepository.findByEventBeneficiaryName(beneficiaryRepo.getDescription());
		Assert.assertEquals(beneficiaryRepo.getId(), repo.getId());
	}
}
