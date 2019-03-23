package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.RoleLookupRepo;

public interface RoleRepository extends CrudRepository<RoleLookupRepo, Integer> {
	
	@Query("SELECT e FROM RoleLookupRepo e WHERE e.id = :roleId")
	RoleLookupRepo findByRoleId(@Param("roleId") int roleId);
	
	@Query("SELECT e FROM RoleLookupRepo e WHERE e.description = :role")
	RoleLookupRepo findByRoleDescription(@Param("role") String role);

}

