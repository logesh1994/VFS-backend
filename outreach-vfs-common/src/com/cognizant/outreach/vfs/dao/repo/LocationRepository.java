package com.cognizant.outreach.vfs.dao.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.outreach.vfs.dao.model.LocationRepo;

public interface LocationRepository extends CrudRepository<LocationRepo, Integer> {
	
	@Query("SELECT e FROM LocationRepo e WHERE e.id = :locationId")
	LocationRepo findByLocationId(@Param("locationId") int locationId);
	
	@Query("SELECT e FROM LocationRepo e WHERE e.city = :cityName")
	LocationRepo findByLocationCityName(@Param("cityName") String cityName);

}

