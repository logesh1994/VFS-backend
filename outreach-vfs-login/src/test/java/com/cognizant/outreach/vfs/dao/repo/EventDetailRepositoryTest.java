package com.cognizant.outreach.vfs.dao.repo;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.EventDetailRepo;

public class EventDetailRepositoryTest extends BaseRepoTest {

	@Autowired
	private EventDetailRepository detailRepository;
	
	private EventDetailRepo detailRepo = null;
	
	@Before
	public void setup() {
		detailRepo = createEventDetailRepo(null, null);
	}
	
	@Test
	public void testFindByEventDetailId() {
		EventDetailRepo repo = detailRepository.findByEventDetailId(detailRepo.getId());
		Assert.assertEquals(detailRepo.getEmployee().getEmployeeId(), repo.getEmployee().getEmployeeId());
	}
	
	@Test
	public void testGetCountBasedOnParticipationStatus() {
		int count = detailRepository.getCountBasedOnParticipationStatus(detailRepo.getEvent().getId(), detailRepo.getStatus1().getDescription());
		Assert.assertEquals(1,  count);
	}
	
	@Test
	public void testGetCountBasedOnFeedbackStatus() {
		int count = detailRepository.getCountBasedOnFeedbackStatus(detailRepo.getEvent().getId(), detailRepo.getStatus2().getDescription());
		Assert.assertEquals(1,  count);
	}
	
	@Test
	public void testFindBasedOnFeedbackStatus() {
		List<EventDetailRepo> repoList = detailRepository.findBasedOnFeedbackStatus(detailRepo.getEvent().getId(), detailRepo.getStatus2().getDescription());
		Assert.assertEquals(1, repoList.size());
	}
	
	@Test
	public void testFindAllBasedOnPOCId() {
		List<EventDetailRepo> repoList = detailRepository.findAllBasedOnPOCId("%512642%");
		Assert.assertEquals(1, repoList.size());
	}
	
}
