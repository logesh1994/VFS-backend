package com.cognizant.outreach.vfs.feedback.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.beanutils.FeedbackBeanUtils;
import com.cognizant.outreach.vfs.dao.model.EventDetailRepo;
import com.cognizant.outreach.vfs.dao.model.FeedbackOptionRepo;
import com.cognizant.outreach.vfs.dao.repo.EventDetailRepository;
import com.cognizant.outreach.vfs.dao.repo.FeedbackOptionRepository;
import com.cognizant.outreach.vfs.dao.repo.FeedbackRepository;
import com.cognizant.outreach.vfs.domain.EventDetails;
import com.cognizant.outreach.vfs.domain.Feedback;
import com.cognizant.outreach.vfs.domain.FeedbackTemplate;
import com.cognizant.outreach.vfs.service.EntityHelperService;

@Service
public class FeedbackService {

	@Autowired
	private EventDetailRepository eventDetailRepository;
	
	@Autowired
	private FeedbackOptionRepository feedbackOptionRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private EntityHelperService entityHelperService;
	
	public FeedbackTemplate getFeedbackTemplateData(int event_Detail_id, int employee_id) {
		FeedbackTemplate feedbackTemplate = null;
		List<String> feedbackOptions = new ArrayList<>();
		EventDetailRepo eventDetailRepo = eventDetailRepository.findByEventDetailId(event_Detail_id);
		if (eventDetailRepo != null && eventDetailRepo.getEmployee().getEmployeeId() == employee_id) {
			if (feedbackRepository.findByEventDetailId(event_Detail_id) == null) {
				feedbackTemplate = new FeedbackTemplate();
				feedbackTemplate.setEmployee_id(String.valueOf(employee_id));
				feedbackTemplate.setEvent_id(String.valueOf(event_Detail_id));
				if (eventDetailRepo.getStatus1().getDescription().equals("Attended")) {
					feedbackTemplate.setFeedback_type("RPA");
					feedbackTemplate.setDisplay_message("Please share your Feedback for the Outreach event "
							+ eventDetailRepo.getEvent().getEvntName() +" that you attended on " + eventDetailRepo.getEvent().getEvntDate());
				} else {
					//TODO Check the message to be displayed
					feedbackTemplate.setDisplay_message("Please share your Feedback for the Outreach event "
							+ eventDetailRepo.getEvent().getEvntName() +" that you missed to attend on " + eventDetailRepo.getEvent().getEvntDate());
					feedbackTemplate.setFeedback_type("RFA");
					for (FeedbackOptionRepo repo : feedbackOptionRepository.findAll()) {
						feedbackOptions.add(repo.getDescription());
					}
					feedbackTemplate.setFeedback_options(feedbackOptions);
				}
			} else {
				feedbackTemplate = new FeedbackTemplate();
				feedbackTemplate.setFeedback_type("Submitted");
				feedbackTemplate.setDisplay_message("You have alreday submitted feedback for Outreach event \""
						+ eventDetailRepo.getEvent().getEvntName() +"\" that Occured on " + eventDetailRepo.getEvent().getEvntDate());
			}
		} else {
			//TODO Incorrect URL Throw Exception and then set API Status Accordingly
		}
		return feedbackTemplate;
	}
	
	public FeedbackTemplate saveFeedbackData(Feedback feedbackData) {
		entityHelperService.addFeedbackData(feedbackData.getImprove_feedback(), 
				feedbackData.getLike_feedback(), feedbackData.getUpdate_id(), feedbackData.getEvent_detail_id(), feedbackData.getFeedback_option(), feedbackData.getRating());
		EventDetailRepo repo = eventDetailRepository.findByEventDetailId(feedbackData.getEvent_detail_id());
		if (repo != null) {
			repo.getStatus2().setDescription("Submitted");
		}
		FeedbackTemplate feedbackTemplate = new FeedbackTemplate();
		if (repo.getStatus1().getDescription().equals("Attended")) {
		feedbackTemplate.setDisplay_message("You feedback for Outreach event \""
				+ repo.getEvent().getEvntName() +"\" that you attended on " + repo.getEvent().getEvntDate() + " has been saved successfully. Thank you for your continued Support !!!");
		} else {
			feedbackTemplate.setDisplay_message("You feedback for Outreach event \""
					+ repo.getEvent().getEvntName() +"\" that occured on " + repo.getEvent().getEvntDate() + " has been saved successfully. Thank you for your continued Support !!!");
		}
		return feedbackTemplate;
		
	}
}
