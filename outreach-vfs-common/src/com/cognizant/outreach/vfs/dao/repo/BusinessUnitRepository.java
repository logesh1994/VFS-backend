package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.BusinessUnitRepo;

public interface BusinessUnitRepository extends CrudRepository<BusinessUnitRepo, Integer> {
	
	@Query("SELECT e FROM BusinessUnitRepo e WHERE e.id = :businessUnitId")
	BusinessUnitRepo findByBusinessUintId(@Param("businessUnitId") int statusId);
	
	@Query("SELECT e FROM BusinessUnitRepo e WHERE e.bussUnitName = :bussUnitName")
	BusinessUnitRepo findByBusinessUnitName(@Param("bussUnitName") String bussUnitName);

}

