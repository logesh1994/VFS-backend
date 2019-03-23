package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.IiepCategoryRepo;

public interface IiepCategoryRepository extends CrudRepository<IiepCategoryRepo, Integer> {
	
	@Query("SELECT e FROM IiepCategoryRepo e WHERE e.id = :locationId")
	IiepCategoryRepo findByIiepCategoryId(@Param("locationId") int loginId);
	
	@Query("SELECT e FROM IiepCategoryRepo e WHERE e.description = :categoryName")
	IiepCategoryRepo findByIiepCategoryName(@Param("categoryName") String categoryName);

}

