package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	@JsonProperty("Rating Id")
    private Integer ratingId;
    
	@JsonProperty("Value")
    private String description;

	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 

}
