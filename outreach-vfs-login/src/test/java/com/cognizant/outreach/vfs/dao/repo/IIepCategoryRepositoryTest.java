package com.cognizant.outreach.vfs.dao.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.IiepCategoryRepo;

public class IIepCategoryRepositoryTest extends BaseRepoTest {

	@Autowired
	private IiepCategoryRepository categoryRepository;
	
	private IiepCategoryRepo iiepCategory = null;
	
	@Before
	public void setUp() {
		iiepCategory = createIiepCategoryRepo("Test IIEP");
	}
	
	@Test
	public void testFindByIiepCategoryId() {
		IiepCategoryRepo repo = categoryRepository.findByIiepCategoryId(iiepCategory.getId());
		Assert.assertEquals(iiepCategory.getDescription(), repo.getDescription());
	}
	
	@Test
	public void testFindByIiepCategoryName() {
		IiepCategoryRepo repo = categoryRepository.findByIiepCategoryName(iiepCategory.getDescription());
		Assert.assertEquals(iiepCategory.getId(), repo.getId());
	}
	
}
