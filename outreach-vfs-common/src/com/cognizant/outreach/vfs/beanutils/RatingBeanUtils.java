package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.RatingRepo;
import com.cognizant.outreach.vfs.domain.Rating;

public final class RatingBeanUtils {

	public static RatingRepo getRatingRepo(Rating rating) {
		RatingRepo ratingRepo = null;
		if (rating != null) {
			ratingRepo = new RatingRepo();
			ratingRepo.setId(rating.getRatingId());
			ratingRepo.setDescription(rating.getDescription());
		}
		return ratingRepo;
	}
	
	public static Rating getRating(RatingRepo ratingRepo) {
		Rating rating = null;
		if (ratingRepo != null) {
			rating = new Rating();
			rating.setRatingId(ratingRepo.getId());
			rating.setDescription(ratingRepo.getDescription());
		}
		return rating;
	}
	
	public static List<Rating> getRatingList(List<RatingRepo> ratingRepoList) {
		List<Rating> ratingList = new ArrayList<>();
		Rating rating = null;
		for (RatingRepo ratingRepo: ratingRepoList) {
			rating = new Rating();
			rating.setRatingId(ratingRepo.getId());
			rating.setDescription(ratingRepo.getDescription());
			ratingList.add(rating);
		}
		return ratingList;
	}
}
