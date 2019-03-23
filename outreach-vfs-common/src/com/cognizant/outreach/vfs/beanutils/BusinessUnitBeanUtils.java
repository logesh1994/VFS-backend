package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.dao.model.BusinessUnitRepo;
import com.cognizant.outreach.vfs.dao.model.LocationRepo;
import com.cognizant.outreach.vfs.dao.repo.LocationRepository;
import com.cognizant.outreach.vfs.domain.BusinessUnit;

public final class BusinessUnitBeanUtils {


//	public static BusinessUnitRepo getBusinessUnitRepo(BusinessUnit businessUnit) {
//		BusinessUnitRepo businessUnitRepo = null;
//		LocationRepo locationRepo = null;
//		if (businessUnit != null) {
//			businessUnitRepo = new BusinessUnitRepo();
//			locationRepo = new LocationRepo();
//			businessUnitRepo.setId(businessUnit.getBusiness_unit_id());
//			businessUnitRepo.setBussUnitName(businessUnit.getBusiness_unit_name());
//		
//		}
//	}
	
	public static List<BusinessUnit> getBusinessUnitList(List<BusinessUnitRepo> businessUnitRepoList) {
		List<BusinessUnit> businessUnitList = new ArrayList<>();
		BusinessUnit businessUnit = null;
		for(BusinessUnitRepo businessUnitRepo: businessUnitRepoList) {
			businessUnit = new BusinessUnit();
			businessUnit.setBusiness_unit_id(businessUnitRepo.getId());
			businessUnit.setBusiness_unit_name(businessUnitRepo.getBussUnitName());
			businessUnit.setBusiness_unit_location(businessUnitRepo.getLocation().getCity());
			businessUnitList.add(businessUnit);
		}
		return businessUnitList;
	}
}
