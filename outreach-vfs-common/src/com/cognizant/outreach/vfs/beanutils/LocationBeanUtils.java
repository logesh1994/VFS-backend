package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.BusinessUnitRepo;
import com.cognizant.outreach.vfs.dao.model.LocationRepo;
import com.cognizant.outreach.vfs.domain.BusinessUnit;
import com.cognizant.outreach.vfs.domain.Location;

public final class LocationBeanUtils {

	public static LocationRepo getLoactionRepo(Location location) {
		LocationRepo locationRepo = null;
		if (location != null) {
			locationRepo = new LocationRepo();
			locationRepo.setId(location.getLocation_id());
			locationRepo.setCity(location.getCity_name());
			locationRepo.setState(location.getState_name());
			locationRepo.setCountry(location.getCountry_name());
		}
		return locationRepo;
	}
	
	public static Location getRole(LocationRepo locationRepo) {
		Location location = null;
		if (locationRepo != null) {
			location = new Location();
			location.setLocation_id(locationRepo.getId());
			location.setCity_name(locationRepo.getCity());
			location.setState_name(locationRepo.getState());
			location.setCountry_name(locationRepo.getCountry());
		}
		return location;
	}
	
	public static List<Location> getLocationsList(List<LocationRepo> locationRepoList) {
		List<Location> locationList = new ArrayList<>();
		Location location = null;
		for(LocationRepo locationRepo: locationRepoList) {
			location = new Location();
			location.setLocation_id(locationRepo.getId());
			location.setCity_name(locationRepo.getCity());
			location.setState_name(locationRepo.getState());
			location.setCountry_name(locationRepo.getCountry());
			locationList.add(location);
		}
		return locationList;
	}
}
