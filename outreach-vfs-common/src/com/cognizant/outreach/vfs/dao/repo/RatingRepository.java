package com.cognizant.outreach.vfs.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.RatingRepo;

public interface RatingRepository extends CrudRepository<RatingRepo, Integer> {
	
	@Query("SELECT e FROM RatingRepo e WHERE e.id = :ratingId")
	RatingRepo findByRatingId(@Param("ratingId") int ratingId);
	
	@Query("SELECT e FROM RatingRepo e WHERE e.description = :rating")
	RatingRepo findByRatingDescription(@Param("rating") String rating);
	
	@Query("SELECT e.description FROM RatingRepo e")
	List<String> findAllDescription();

}

