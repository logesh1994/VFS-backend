package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.EventDetailRepo;

public interface EventDetailRepository extends CrudRepository<EventDetailRepo, Integer> {
	
	@Query("SELECT e FROM EventDetailRepo e WHERE e.id = :eventDetailId")
	EventDetailRepo findByEventDetailId(@Param("eventDetailId") int eventDetailId);

}

