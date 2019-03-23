package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.FeedbackOptionRepo;
import com.cognizant.outreach.vfs.domain.FeedbackOptions;

public final class FeedbackOptionsBeanUtils {

	public static FeedbackOptionRepo getFeedbackOptionsRepo(FeedbackOptions feedbackOptions) {
		FeedbackOptionRepo feedbackOptionRepo = null;
		if (feedbackOptions != null) {
			feedbackOptionRepo = new FeedbackOptionRepo();
			feedbackOptionRepo.setId(feedbackOptions.getOption_id());
			feedbackOptionRepo.setDescription(feedbackOptions.getOption_description());
		}
		return feedbackOptionRepo;
	}
	
	public static FeedbackOptions getFeedbackOptions(FeedbackOptionRepo feedbackOptionRepo) {
		FeedbackOptions feedbackOptions = null;
		if (feedbackOptionRepo != null) {
			feedbackOptions = new FeedbackOptions();
			feedbackOptions.setOption_id(feedbackOptionRepo.getId());
			feedbackOptions.setOption_description(feedbackOptionRepo.getDescription());
		}
		return feedbackOptions;
	}
	
	public static List<FeedbackOptions> getFeedbackOptionsList(List<FeedbackOptionRepo> feedbackOptionRepoList) {
		List<FeedbackOptions> feedbackOptionsList = new ArrayList<>();
		FeedbackOptions feedbackOptions = null;
		for(FeedbackOptionRepo feedbackOptionRepo: feedbackOptionRepoList) {
			feedbackOptions = new FeedbackOptions();
			feedbackOptions.setOption_id(feedbackOptionRepo.getId());
			feedbackOptions.setOption_description(feedbackOptionRepo.getDescription());
			feedbackOptionsList.add(feedbackOptions);
		}
		return feedbackOptionsList;
	}
}
