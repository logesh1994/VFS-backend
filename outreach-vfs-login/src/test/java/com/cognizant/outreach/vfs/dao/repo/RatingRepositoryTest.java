package com.cognizant.outreach.vfs.dao.repo;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.outreach.vfs.BaseRepoTest;
import com.cognizant.outreach.vfs.dao.model.RatingRepo;

public class RatingRepositoryTest extends BaseRepoTest {

	@Autowired
	private RatingRepository ratingRepository;
	
	private RatingRepo ratingRepo = null;
	
	@Before
	public void setUp() {
		ratingRepo = createRatingRepo("Test Rating");
	}
	
	@Test
	public void testFindByRatingId() {
		RatingRepo repo = ratingRepository.findByRatingId(ratingRepo.getId());
		Assert.assertEquals(ratingRepo.getDescription(), repo.getDescription());
	}
	
	@Test
	public void testFindByRatingDescription() {
		RatingRepo repo = ratingRepository.findByRatingDescription(ratingRepo.getDescription());
		Assert.assertEquals(ratingRepo.getId(), repo.getId());
	}
	
	@Test
	public void testFindAllDescription() {
		List<String> ratinglist = ratingRepository.findAllDescription();
		Assert.assertEquals(ratingRepo.getDescription(), ratinglist.get(0));
	}
	
}
