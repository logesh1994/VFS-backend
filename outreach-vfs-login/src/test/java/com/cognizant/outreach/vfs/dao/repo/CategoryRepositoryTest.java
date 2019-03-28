package com.cognizant.outreach.vfs.dao.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.CategoryRepo;

public class CategoryRepositoryTest extends BaseRepoTest {

	@Autowired
	private CategoryRepository categoryRepository;
	
	private CategoryRepo categoryRepo = null;
	
	@Before
	public void setUp() {
		categoryRepo = createCategoryRepo("Test Category");
	}
	
	@Test
	public void testFindByCategoryId() {
		CategoryRepo repo = categoryRepository.findByCategoryId(categoryRepo.getId());
		Assert.assertEquals(categoryRepo.getDescription(), repo.getDescription());
	}
	
	@Test
	public void testFindByCategoryDescription() {
		CategoryRepo repo = categoryRepository.findByCategoryDescription(categoryRepo.getDescription());
		Assert.assertEquals(categoryRepo.getId(), repo.getId());
	}
	
}
