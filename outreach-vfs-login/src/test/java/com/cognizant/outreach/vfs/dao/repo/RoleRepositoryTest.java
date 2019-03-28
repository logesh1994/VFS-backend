package com.cognizant.outreach.vfs.dao.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.RoleLookupRepo;

public class RoleRepositoryTest extends BaseRepoTest {

	@Autowired
	private RoleRepository roleRepository;
	
	private RoleLookupRepo roleRepo = null;
	
	@Before
	public void setUp() {
		roleRepo = createRoleRepo("Admin");
	}
	
	@Test
	public void testFindByRoleId() {
		RoleLookupRepo repo = roleRepository.findByRoleId(roleRepo.getId());
		Assert.assertEquals(roleRepo.getDescription(), repo.getDescription());
	}
	
	@Test
	public void testFindByRoleDescription() {
		RoleLookupRepo repo = roleRepository.findByRoleDescription(roleRepo.getDescription());
		Assert.assertEquals(roleRepo.getId(), repo.getId());
	}
}
