package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.EventDetailRepo;
import com.cognizant.outreach.vfs.domain.EventDetails;

public final class EventDetailsBeanUtils {

	public static List<EventDetails> getEventDetailsList(List<EventDetailRepo> eventDetailsRepoList) {
		List<EventDetails> eventDetailsList = new ArrayList<>();
		EventDetails eventDetail = null;
		for (EventDetailRepo eventDetailRepo: eventDetailsRepoList) {
			eventDetail = new EventDetails();
			eventDetail.setEvent_details_id(eventDetailRepo.getId());
			eventDetail.setEvent_id(eventDetailRepo.getEvent().getId());
			eventDetail.setEmployee_id(eventDetailRepo.getEmployee().getEmployeeId());
			eventDetail.setVolunteer_hrs(eventDetailRepo.getVolunteerHrs());
			eventDetail.setTravel_hrs(eventDetailRepo.getTravelHrs());
			eventDetail.setParticipation_status(eventDetailRepo.getStatus1().getDescription());
			eventDetail.setFeedback_status(eventDetailRepo.getStatus2().getDescription());
			eventDetail.setCreated_by(eventDetailRepo.getCreatedById());
			eventDetailsList.add(eventDetail);
		}
		return eventDetailsList;
	}

}
