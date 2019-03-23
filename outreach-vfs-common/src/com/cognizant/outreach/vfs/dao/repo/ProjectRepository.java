package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.ProjectRepo;

public interface ProjectRepository extends CrudRepository<ProjectRepo, Integer> {
	
	@Query("SELECT e FROM ProjectRepo e WHERE e.id = :projectId")
	ProjectRepo findByProjectId(@Param("projectId") int projectId);
	
	@Query("SELECT e FROM ProjectRepo e WHERE e.description = :name")
	ProjectRepo findByProjectDescription(@Param("name") String name);

}

