package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.IiepCategoryRepo;
import com.cognizant.outreach.vfs.domain.IiepCategory;

public final class IiepCategoryBeanUtils {

	public static IiepCategoryRepo getIiepCategoryRepo(IiepCategory iiepCategory) {
		IiepCategoryRepo iiepCategoryRepo = null;
		if (iiepCategory != null) {
			iiepCategoryRepo = new IiepCategoryRepo();
			iiepCategoryRepo.setId(iiepCategory.getIiep_category_id());
			iiepCategoryRepo.setDescription(iiepCategory.getIiep_category_name());
		}
		return iiepCategoryRepo;
	}
	
	public static IiepCategory getIiepCategory(IiepCategoryRepo iiepCategoryRepo) {
		IiepCategory iiepCategory = null;
		if (iiepCategoryRepo != null) {
			iiepCategory = new IiepCategory();
			iiepCategory.setIiep_category_id(iiepCategoryRepo.getId());
			iiepCategory.setIiep_category_name(iiepCategoryRepo.getDescription());
		}
		return iiepCategory;
	}
	
	public static List<IiepCategory> getIiepCategoryList(List<IiepCategoryRepo> iiepCategoryRepoList) {
		List<IiepCategory> iiepCategoryList = new ArrayList<>();
		IiepCategory iiepCategory = null;
		for(IiepCategoryRepo iiepCategoryRepo: iiepCategoryRepoList) {
			iiepCategory = new IiepCategory();
			iiepCategory.setIiep_category_id(iiepCategoryRepo.getId());
			iiepCategory.setIiep_category_name(iiepCategoryRepo.getDescription());
			iiepCategoryList.add(iiepCategory);
		}
		return iiepCategoryList;
	}
}
