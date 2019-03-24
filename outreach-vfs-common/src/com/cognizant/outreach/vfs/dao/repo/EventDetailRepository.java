package com.cognizant.outreach.vfs.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.EventDetailRepo;

public interface EventDetailRepository extends CrudRepository<EventDetailRepo, Integer> {
	
	@Query("SELECT e FROM EventDetailRepo e WHERE e.id = :eventDetailId")
	EventDetailRepo findByEventDetailId(@Param("eventDetailId") int eventDetailId);
	
	@Query("SELECT count(1) FROM EventDetailRepo e WHERE e.event.id = :eventId and  e.status1.description = :status")
	int getCountBasedOnParticipationStatus(@Param("eventId") String eventId, @Param("status") String status);
	
	@Query("SELECT count(1) FROM EventDetailRepo e WHERE e.event.id = :eventId and  e.status2.description = :status")
	int getCountBasedOnFeedbackStatus(@Param("eventId") String eventId, @Param("status") String status);
	
	@Query("SELECT e FROM EventDetailRepo e WHERE e.event.id = :eventId and  e.status2.description = :status")
	List<EventDetailRepo> findBasedOnFeedbackStatus(@Param("eventId") String eventId, @Param("status") String status);

}

