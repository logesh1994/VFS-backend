package com.cognizant.outreach.vfs.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackTemplate {

	@JsonInclude()
	@JsonProperty("EventDetail Id")
	private String event_id;
	
	@JsonProperty("Employee Id")
	private String employee_id;
	
	@JsonProperty("Feedback Options")
	private List<String> feedback_options;
	
	@JsonProperty("Feedback Type")
	private String feedback_type;
	
	@JsonProperty("Display Message")
	private String display_message;
	
	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public List<String> getFeedback_options() {
		return feedback_options;
	}

	public void setFeedback_options(List<String> feedback_options) {
		this.feedback_options = feedback_options;
	}

	public String getFeedback_type() {
		return feedback_type;
	}

	public void setFeedback_type(String feedback_type) {
		this.feedback_type = feedback_type;
	}

	public String getDisplay_message() {
		return display_message;
	}

	public void setDisplay_message(String display_message) {
		this.display_message = display_message;
	}
	
	
}
