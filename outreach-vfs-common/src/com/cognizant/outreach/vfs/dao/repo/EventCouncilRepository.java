package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.EventCouncilRepo;

public interface EventCouncilRepository extends CrudRepository<EventCouncilRepo, Integer> {
	
	@Query("SELECT e FROM EventCouncilRepo e WHERE e.id = :eventCouncilId")
	EventCouncilRepo findByEventCouncilId(@Param("eventCouncilId") int eventCouncilId);
	
	@Query("SELECT e FROM EventCouncilRepo e WHERE e.councilName = :eventCouncilName")
	EventCouncilRepo findByEventCouncilName(@Param("eventCouncilName") String eventCouncilName);

}

