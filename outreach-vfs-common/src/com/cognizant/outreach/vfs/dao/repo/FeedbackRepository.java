package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.FeedbackRepo;

public interface FeedbackRepository extends CrudRepository<FeedbackRepo, Integer> {
	
	@Query("SELECT e FROM FeedbackRepo e WHERE e.id = :feedbackId")
	FeedbackRepo findByFeedbackId(@Param("feedbackId") int feedbackId);
	
	@Query("SELECT e FROM FeedbackRepo e WHERE e.eventDetail.id = :eventDetailId")
	FeedbackRepo findByEventDetailId(@Param("eventDetailId") int eventDetailId);

}

