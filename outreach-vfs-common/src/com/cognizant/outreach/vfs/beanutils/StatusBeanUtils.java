package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.StatusRepo;
import com.cognizant.outreach.vfs.domain.Status;

public final class StatusBeanUtils {

	public static StatusRepo getStatusRepo(Status status) {
		StatusRepo statusRepo = null;
		if (status != null) {
			statusRepo = new StatusRepo();
			statusRepo.setId(status.getStatusId());
			statusRepo.setDescription(status.getDescription());
		}
		return statusRepo;
	}
	
	public static Status getStatus(StatusRepo statusRepo) {
		Status status = null;
		if (statusRepo != null) {
			status =new Status();
			status.setStatusId(statusRepo.getId());
			status.setDescription(statusRepo.getDescription());
		}
		return status;
	}
	
	public static List<Status> getStatusList(List<StatusRepo> statusRepoList) {
		List<Status> statusList = new ArrayList<>();
		Status status = null;
		for (StatusRepo statusRepo: statusRepoList) {
			status = new Status();
			status.setStatusId(statusRepo.getId());
			status.setDescription(statusRepo.getDescription());
			statusList.add(status);
		}
		return statusList;
	}
}
