package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.CategoryRepo;

public interface CategoryRepository extends CrudRepository<CategoryRepo, Integer> {
	
	@Query("SELECT e FROM CategoryRepo e WHERE e.id = :categoryId")
	CategoryRepo findByCategoryId(@Param("categoryId") int categoryId);
	
	@Query("SELECT e FROM CategoryRepo e WHERE e.description = :name")
	CategoryRepo findByCategoryDescription(@Param("name") String name);

}

