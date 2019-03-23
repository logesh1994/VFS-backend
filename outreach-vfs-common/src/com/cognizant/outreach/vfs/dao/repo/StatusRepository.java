package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.StatusRepo;

public interface StatusRepository extends CrudRepository<StatusRepo, Integer> {
	
	@Query("SELECT e FROM StatusRepo e WHERE e.id = :statusId")
	StatusRepo findByStatusId(@Param("statusId") int statusId);
	
	@Query("SELECT e FROM StatusRepo e WHERE e.description = :status")
	StatusRepo findByStatusDescription(@Param("status") String status);

}

