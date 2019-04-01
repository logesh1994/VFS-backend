package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.FeedbackRepo;
import com.cognizant.outreach.vfs.domain.Feedback;

public final class FeedbackBeanUtils {
	
	public static List<Feedback> getFeedbackList(List<FeedbackRepo> feedbackRepoList) {
		List<Feedback> feedbackList = new ArrayList<>();
		Feedback feedback = null;
		for(FeedbackRepo feedbackRepo: feedbackRepoList) {
			feedback = new Feedback();
			feedback.setFeedback_id(feedbackRepo.getId());
			feedback.setEvent_detail_id(feedbackRepo.getEventDetail().getId());
			if (feedbackRepo.getRatingBean() != null ) {
				feedback.setRating(feedbackRepo.getRatingBean().getDescription());
			}
			if (feedbackRepo.getFeedbackOption() != null) {
				feedback.setFeedback_option(feedbackRepo.getFeedbackOption().getDescription());
			}
			feedback.setLike_feedback(feedbackRepo.getLikeFeedback());
			feedback.setImprove_feedback(feedbackRepo.getImproveFeedback());
			feedback.setAdmin_feedback(feedbackRepo.getAdminFeedback());
			feedback.setUpdate_id(feedbackRepo.getEmployee().getEmployeeId());
			feedbackList.add(feedback);
		}
		return feedbackList;
	}
	
}
