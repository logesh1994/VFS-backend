package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackOptions implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Option Id")
    private int option_id;
    
    @JsonProperty("Description")
    private String option_description;
    
	public int getOption_id() {
		return option_id;
	}
	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}
	public String getOption_description() {
		return option_description;
	}
	public void setOption_description(String option_description) {
		this.option_description = option_description;
	}

}
