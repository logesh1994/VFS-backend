package com.cognizant.outreach.vfs.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.beanutils.EventDetailsBeanUtils;
import com.cognizant.outreach.vfs.beanutils.FeedbackBeanUtils;
import com.cognizant.outreach.vfs.dao.model.EventDetailRepo;
import com.cognizant.outreach.vfs.dao.model.FeedbackRepo;
import com.cognizant.outreach.vfs.dao.repo.EventDetailRepository;
import com.cognizant.outreach.vfs.dao.repo.FeedbackRepository;
import com.cognizant.outreach.vfs.domain.AdminTableData;
import com.cognizant.outreach.vfs.domain.EventDetails;
import com.cognizant.outreach.vfs.domain.Feedback;
import com.cognizant.outreach.vfs.util.AdminTableUtils;

@Service
public class EventAndFeedBackDataService {

	@Autowired
	private EventDetailRepository eventDetailRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	
	public List<AdminTableData> getEventDetailsAndFeedbackDetails() {
		List<AdminTableData> adminTableDataList = new ArrayList<>();

    	adminTableDataList.add(new AdminTableData("Event Details",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Event Details"), 
    			getAllEventDetailData()));
    	adminTableDataList.add(new AdminTableData("Feedback",
    			AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.get("Feedback"), 
    			getAllFeedbackData()));
    	
    	return adminTableDataList;
	}
	
	public List<EventDetails> getAllEventDetailData() {
    	List<EventDetailRepo> eventDetailRepoList = new ArrayList<>();
    	CollectionUtils.addAll(eventDetailRepoList, eventDetailRepository.findAll());
    	return EventDetailsBeanUtils.getEventDetailsList(eventDetailRepoList);
    }
	
	public List<Feedback> getAllFeedbackData() {
    	List<FeedbackRepo> feedbackRepoList = new ArrayList<>();
    	CollectionUtils.addAll(feedbackRepoList, feedbackRepository.findAll());
    	return FeedbackBeanUtils.getFeedbackList(feedbackRepoList);
    }
	
}
