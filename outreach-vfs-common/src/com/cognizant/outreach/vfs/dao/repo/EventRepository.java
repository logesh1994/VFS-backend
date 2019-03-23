package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.EventRepo;

public interface EventRepository extends CrudRepository<EventRepo, String> {
	
	@Query("SELECT e FROM EventRepo e WHERE e.id = :eventId")
	EventRepo findByEventId(@Param("eventId") String eventId);

}

