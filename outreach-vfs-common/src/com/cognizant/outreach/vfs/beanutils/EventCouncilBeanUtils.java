package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.EventCouncilRepo;
import com.cognizant.outreach.vfs.domain.EventCouncil;

public final class EventCouncilBeanUtils {
	
	public static List<EventCouncil> getEventCouncilList(List<EventCouncilRepo> eventCouncilRepoList) {
		List<EventCouncil> eventCouncilList = new ArrayList<>();
		EventCouncil eventCouncil = null;
		for(EventCouncilRepo eventCouncilRepo: eventCouncilRepoList) {
			eventCouncil = new EventCouncil();
			eventCouncil.setEvent_council_id(eventCouncilRepo.getId());
			eventCouncil.setEvent_council_name(eventCouncilRepo.getCouncilName());
			eventCouncil.setLocation_name(eventCouncilRepo.getLocation().getCity());
			eventCouncilList.add(eventCouncil);
		}
		return eventCouncilList;
	}

}
