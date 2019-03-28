package com.cognizant.outreach.vfs.dao.repo;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.FeedbackOptionRepo;

public class FeedbackOptionRepositoryTest extends BaseRepoTest {

	@Autowired
	private FeedbackOptionRepository feedbackOptionRepository;
	
	private FeedbackOptionRepo option = null;
	
	@Before
	public void setUp() {
		option = createFeedbackOptionRepo("Test option");
	}
	
	@Test
	public void testFindByFeedbackOptionId() {
		FeedbackOptionRepo repo = feedbackOptionRepository.findByFeedbackOptionId(option.getId());
		Assert.assertEquals(option.getDescription(), repo.getDescription());
	}
	
	@Test
	public void testFindByFeedbackOption() {
		FeedbackOptionRepo repo = feedbackOptionRepository.findByFeedbackOption(option.getDescription());
		Assert.assertEquals(option.getId(), repo.getId());
	}
	
	@Test
	public void testFindAllFeedbackOptions() {
		List<String> repoList = feedbackOptionRepository.findAllFeedbackOptions();
		Assert.assertEquals(option.getDescription(), repoList.get(0));
	}
	
}
