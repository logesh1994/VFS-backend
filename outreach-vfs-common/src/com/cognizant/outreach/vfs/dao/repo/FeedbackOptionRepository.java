package com.cognizant.outreach.vfs.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.FeedbackOptionRepo;

public interface FeedbackOptionRepository extends CrudRepository<FeedbackOptionRepo, Integer> {
	
	@Query("SELECT e FROM FeedbackOptionRepo e WHERE e.id = :optionId")
	FeedbackOptionRepo findByFeedbackOptionId(@Param("optionId") int optionId);
	
	@Query("SELECT e FROM FeedbackOptionRepo e WHERE e.description = :option")
	FeedbackOptionRepo findByFeedbackOption(@Param("option") String option);
	
	@Query("SELECT e.description FROM FeedbackOptionRepo e")
	List<String> findAllFeedbackOptions();

}

