package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.EmployeeRepo;


public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeRepo, Integer> {
	
	@Query("SELECT e FROM EmployeeRepo e WHERE e.employeeId = :loginId")
	EmployeeRepo findByLoginId(@Param("loginId") int loginId);

}