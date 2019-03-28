package com.cognizant.outreach.vfs.dao.repo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.EmployeeRepo;

public class EmployeeRepositoryTest extends BaseRepoTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	private EmployeeRepo employeeRepo = null;
	
	@Before
	public void setUp() {
		employeeRepo = createEmployeeRepo(500001);
	}
	
	@Test
	public void testFindByLoginId() {
		EmployeeRepo repo = employeeRepository.findByLoginId(500001);
		Assert.assertEquals(employeeRepo.getEmpFirstName(), repo.getEmpFirstName());
	}
	
	@Test
	public void testFindListbyRole() {
		List<String> roleList = new ArrayList();
		roleList.add("Admin");
		List<EmployeeRepo> repoList = employeeRepository.findListbyRole(roleList);
		Assert.assertEquals(employeeRepo.getRoleLookup().getDescription(), repoList.get(0).getRoleLookup().getDescription());
	}
	
}
