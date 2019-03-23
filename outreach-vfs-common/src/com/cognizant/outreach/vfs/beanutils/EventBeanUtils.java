package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.EventRepo;
import com.cognizant.outreach.vfs.domain.Event;

public final class EventBeanUtils {

	public static List<Event> getEventList(List<EventRepo> eventRepoList) {
		List<Event> eventList = new ArrayList<>();
		Event event = null;
		for (EventRepo eventRepo: eventRepoList) {
			event = new Event();
			event.setEventId(eventRepo.getId());
			event.setEvent_base_loaction(eventRepo.getLocation().getCity());
			event.setEvent_benificiary_name(eventRepo.getEventBeneficiary().getDescription());
			event.setEvent_name(eventRepo.getEvntName());
			event.setMonth(eventRepo.getMonth());
			event.setProject_name(eventRepo.getProject().getDescription());
			event.setCategory_name(eventRepo.getCategory().getDescription());
			event.setEvent_description(eventRepo.getEvntDescription());
			event.setVenue_address(eventRepo.getVenueAddress());
			event.setEvent_date(eventRepo.getEvntDate());
			event.setEvent_poc_id(eventRepo.getEventPoc_s());
			event.setLives_impacted(eventRepo.getLivesImpacted());
			event.setTotal_volunteers(eventRepo.getTotalVolunteers());
			event.setTotal_volunteer_hrs(eventRepo.getTotalVolunteerHrs());
			event.setTotal_travel_hrs(eventRepo.getTotalVolunteerHrs());
			event.setOverall_volunteer_hrs(eventRepo.getOverallVolunteerHrs());
			event.setIiep_category(eventRepo.getIiepCategory().getDescription());
			event.setEvent_council_name(eventRepo.getEventCouncil().getCouncilName());
			event.setCreated_by_id(eventRepo.getCreatedById());
			eventList.add(event);
		}
		return eventList;
	}
	
//	public static EventRepo getEventRepo(Event event) {
//		EventRepo eventRepo = new EventRepo();
//		eventRepo.setId(event.getEventId());
//		eventRepo.setLocation(location);
//		eventRepo.setEvent_benificiary_name(eventRepo.getEventBeneficiary().getDescription());
//		eventRepo.setEvent_name(eventRepo.getEvntName());
//		eventRepo.setMonth(eventRepo.getMonth());
//		eventRepo.setProject_name(eventRepo.getProject().getDescription());
//		event.setCategory_name(eventRepo.getCategory().getDescription());
//		eventRepo.setEvent_description(eventRepo.getEvntDescription());
//		event.setVenue_address(eventRepo.getVenueAddress());
//		event.setEvent_date(eventRepo.getEvntDate());
//		event.setEvent_poc_id(eventRepo.getEventPoc_s());
//		event.setLives_impacted(eventRepo.getLivesImpacted());
//		event.setTotal_volunteers(eventRepo.getTotalVolunteers());
//		event.setTotal_volunteer_hrs(eventRepo.getTotalVolunteerHrs());
//		event.setTotal_travel_hrs(eventRepo.getTotalVolunteerHrs());
//		event.setOverall_volunteer_hrs(eventRepo.getOverallVolunteerHrs());
//		event.setIiep_category(eventRepo.getIiepCategory().getDescription());
//		event.setEvent_council_name(eventRepo.getEventCouncil().getCouncilName());
//		event.setCreated_by_id(eventRepo.getCreatedById());
//	}

}
