package com.cognizant.outreach.vfs.dao.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.EventRepo;

public interface EventRepository extends CrudRepository<EventRepo, String> {
	
	@Query("SELECT e FROM EventRepo e WHERE e.id = :eventId")
	EventRepo findByEventId(@Param("eventId") String eventId);
	
	@Query("SELECT e.id FROM EventRepo e WHERE e.evntDate between :fromDate and :toDate")
	List<String> findEventIdListBetweenDates(@Param("fromDate") Date fromDate,@Param("toDate")  Date toDate);
	
	@Query("SELECT e FROM EventRepo e WHERE e.evntDate between :fromDate and :toDate")
	List<EventRepo> findEventListBetweenDates(@Param("fromDate") Date fromDate,@Param("toDate")  Date toDate);

}

