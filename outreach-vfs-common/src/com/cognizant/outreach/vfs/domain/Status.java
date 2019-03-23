package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("Status Id")
	private Integer statusId;
    
	@JsonProperty("Value")
    private String description;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
