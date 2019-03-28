package com.cognizant.outreach.vfs.dao.repo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.FeedbackRepo;

public class FeedbackRepositoryTest extends BaseRepoTest {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	private FeedbackRepo feedback = null;
	
	@Before
	public void setUp() {
		feedback = createFeedbackRepo();
	}
	
	@Test
	public void testFindByFeedbackId() {
		FeedbackRepo repo = feedbackRepository.findByFeedbackId(feedback.getId());
		Assert.assertEquals(feedback.getImproveFeedback(), repo.getImproveFeedback());
	}
	
	@Test
	public void testFindByEventDetailId() {
		FeedbackRepo repo = feedbackRepository.findByEventDetailId(feedback.getEventDetail().getId());
		Assert.assertEquals(feedback.getImproveFeedback(), repo.getImproveFeedback());
	}
	
	@Test
	public void testFindRatingDataForEventIdAndStatus() {
		List<String> eventIdList = new ArrayList<String>();
		eventIdList.add(feedback.getEventDetail().getEvent().getId());
		List<FeedbackRepo> repoList = feedbackRepository.findRatingDataForEventIdAndStatus(eventIdList, feedback.getEventDetail().getStatus1().getDescription());
		Assert.assertEquals(feedback.getImproveFeedback(), repoList.get(0).getImproveFeedback());
	}
	
	@Test
	public void testFindAllByEventPOC() {
		List<FeedbackRepo> repoList = feedbackRepository.findAllByEventPOC("%512642%");
		Assert.assertEquals(feedback.getImproveFeedback(), repoList.get(0).getImproveFeedback());
	}
}
