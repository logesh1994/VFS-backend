package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.EventBeneficiaryRepo;

public interface EventBeneficiaryRepository extends CrudRepository<EventBeneficiaryRepo, Integer> {
	
	@Query("SELECT e FROM EventBeneficiaryRepo e WHERE e.id = :eventBeneficiaryId")
	EventBeneficiaryRepo findByEventBeneficiaryId(@Param("eventBeneficiaryId") int eventBenificiaryId);
	
	@Query("SELECT e FROM EventBeneficiaryRepo e WHERE e.description = :eventBeneficiaryName")
	EventBeneficiaryRepo findByEventBeneficiaryName(@Param("eventBeneficiaryName") String eventBeneficiaryName);

}

