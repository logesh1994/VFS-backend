package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.CategoryRepo;
import com.cognizant.outreach.vfs.domain.Category;

public final class CategoryBeanUtils {
	
	public static List<Category> getCategoryList(List<CategoryRepo> categoryRepoList) {
		List<Category> categoryList = new ArrayList<>();
		Category category = null;
		for (CategoryRepo categoryRepo: categoryRepoList) {
			category = new Category();
			category.setCategory_id(categoryRepo.getId());
			category.setCategory_name(categoryRepo.getDescription());
			categoryList.add(category);
		}
		return categoryList;
	}
}
