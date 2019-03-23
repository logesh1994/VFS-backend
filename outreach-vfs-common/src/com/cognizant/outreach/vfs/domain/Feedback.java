package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("Feedback Id")
    private int feedback_id;
    
    @JsonProperty("Event Detail Id")
    private int event_detail_id;
    
    @JsonProperty("Rating")
    private String rating;
    
    @JsonProperty("Reason")
    private String feedback_option;
    
    @JsonProperty("Positives")
    private String like_feedback;
    
    @JsonProperty("Suggested Improvements")
    private String improve_feedback;
    
    @JsonProperty("Admin Feedback")
    private String admin_feedback;
    
    @JsonProperty("Updated By")
    private int update_id;
    
    private String created_timestamp;
    private String updated_timrstamp;
    
	public int getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}
	public int getEvent_detail_id() {
		return event_detail_id;
	}
	public void setEvent_detail_id(int event_detail_id) {
		this.event_detail_id = event_detail_id;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getFeedback_option() {
		return feedback_option;
	}
	public void setFeedback_option(String feedback_option) {
		this.feedback_option = feedback_option;
	}
	public String getLike_feedback() {
		return like_feedback;
	}
	public void setLike_feedback(String like_feedback) {
		this.like_feedback = like_feedback;
	}
	public String getImprove_feedback() {
		return improve_feedback;
	}
	public void setImprove_feedback(String improve_feedback) {
		this.improve_feedback = improve_feedback;
	}
	public String getAdmin_feedback() {
		return admin_feedback;
	}
	public void setAdmin_feedback(String admin_feedback) {
		this.admin_feedback = admin_feedback;
	}
	public int getUpdate_id() {
		return update_id;
	}
	public void setUpdate_id(int update_id) {
		this.update_id = update_id;
	}
	public String getCreated_timestamp() {
		return created_timestamp;
	}
	public void setCreated_timestamp(String created_timestamp) {
		this.created_timestamp = created_timestamp;
	}
	public String getUpdated_timrstamp() {
		return updated_timrstamp;
	}
	public void setUpdated_timrstamp(String updated_timrstamp) {
		this.updated_timrstamp = updated_timrstamp;
	}
    
}
