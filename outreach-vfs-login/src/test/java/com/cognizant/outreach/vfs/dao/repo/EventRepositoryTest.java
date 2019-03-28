package com.cognizant.outreach.vfs.dao.repo;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.EventRepo;

public class EventRepositoryTest extends BaseRepoTest {

	@Autowired
	private EventRepository eventRepository;
	
	private EventRepo event = null;
	
	@Before
	public void setUp() {
		event = createEventRepo();
	}
	
	@Test
	public void testFindByEventId() {
		EventRepo repo = eventRepository.findByEventId(event.getId());
		Assert.assertEquals(event.getEvntName(), repo.getEvntName());
	}
	
	@Test
	public void testFindEventIdListBetweenDates() {
		List<String> eventIdList = eventRepository.findEventIdListBetweenDates(new Date(System.currentTimeMillis()-24*60*60*1000), new Date());
		Assert.assertEquals(event.getId(), eventIdList.get(0));
	}
	
	@Test
	public void testFindEventIdListBetweenDatesForPOC() {
		List<String> eventIdList = eventRepository.findEventIdListBetweenDatesForPOC(new Date(System.currentTimeMillis()-24*60*60*1000), new Date(), "%512642%");
		Assert.assertEquals(event.getId(), eventIdList.get(0));
	}
	
	@Test
	public void testFindEventListBetweenDates() {
		List<EventRepo> eventList = eventRepository.findEventListBetweenDates(new Date(System.currentTimeMillis()-24*60*60*1000), new Date());
		Assert.assertEquals(event.getEvntName(), eventList.get(0).getEvntName());
	}
	
	@Test
	public void testFindEventListBetweenDatesForPOC() {
		List<EventRepo> eventList = eventRepository.findEventListBetweenDatesForPOC(new Date(System.currentTimeMillis()-24*60*60*1000), new Date(), "%512642%");
		Assert.assertEquals(event.getEvntName(), eventList.get(0).getEvntName());
	}
}
