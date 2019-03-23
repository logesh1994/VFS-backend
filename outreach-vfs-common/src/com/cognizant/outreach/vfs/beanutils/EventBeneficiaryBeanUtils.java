package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.EventBeneficiaryRepo;
import com.cognizant.outreach.vfs.domain.EventBeneficiary;

public final class EventBeneficiaryBeanUtils {

	public static List<EventBeneficiary> getEventBeneficiaryList(List<EventBeneficiaryRepo> eventBenificiaryRepoList) {
		List<EventBeneficiary> eventBeneficiaryList = new ArrayList<>();
		EventBeneficiary eventBeneficiary = null;
		for(EventBeneficiaryRepo eventBenificiaryRepo : eventBenificiaryRepoList) {
			eventBeneficiary = new EventBeneficiary();
			eventBeneficiary.setEvent_benificiary_id(eventBenificiaryRepo.getId());
			eventBeneficiary.setEvent_benificiary_name(eventBenificiaryRepo.getDescription());
			eventBeneficiaryList.add(eventBeneficiary);
		}
		return eventBeneficiaryList;
	}
}
