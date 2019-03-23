package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("Event Details Id")
    private int event_details_id;
    
    @JsonProperty("Event Id")
    private String event_id;
    
    @JsonProperty("Employee Id")
    private int employee_id;
    
    @JsonProperty("Volunteer Hours")
    private float volunteer_hrs;
    
    @JsonProperty("Travel Hours")
    private float travel_hrs;
    
    @JsonProperty("Participation Status")
    private String participation_status;
    
    @JsonProperty("Feedback Status")
    private String feedback_status;
    
    @JsonProperty("Created By")
    private int created_by;
    
    private String created_timestamp;
    private String updated_timestamp;
    
	public int getEvent_details_id() {
		return event_details_id;
	}
	public void setEvent_details_id(int event_details_id) {
		this.event_details_id = event_details_id;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public float getVolunteer_hrs() {
		return volunteer_hrs;
	}
	public void setVolunteer_hrs(float volunteer_hrs) {
		this.volunteer_hrs = volunteer_hrs;
	}
	public float getTravel_hrs() {
		return travel_hrs;
	}
	public void setTravel_hrs(float travel_hrs) {
		this.travel_hrs = travel_hrs;
	}
	public String getParticipation_status() {
		return participation_status;
	}
	public void setParticipation_status(String participation_status) {
		this.participation_status = participation_status;
	}
	public String getFeedback_status() {
		return feedback_status;
	}
	public void setFeedback_status(String feedback_status) {
		this.feedback_status = feedback_status;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public String getCreated_timestamp() {
		return created_timestamp;
	}
	public void setCreated_timestamp(String created_timestamp) {
		this.created_timestamp = created_timestamp;
	}
	public String getUpdated_timestamp() {
		return updated_timestamp;
	}
	public void setUpdated_timestamp(String updated_timestamp) {
		this.updated_timestamp = updated_timestamp;
	}
    
}
