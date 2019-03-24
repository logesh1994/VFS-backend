package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;
import java.util.Date;

import com.cognizant.outreach.vfs.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class Event implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("Event Id")
	private String eventId;
	
	@JsonProperty("Location")
	private String event_base_loaction;
	
	@JsonProperty("Beneficiary Name")
	private String event_benificiary_name;
	
	@JsonProperty("Event Name")
	private String event_name;
	
	@JsonProperty("Month")
	private String month;
	
	@JsonProperty("Project")
	private String project_name;
	
	@JsonProperty("Category")
	private String category_name;
	
	@JsonProperty("Event Description")
	private String event_description;
	
	@JsonProperty("Venue Address")
	private String venue_address;
	
	//@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("Event Date")
    private Date event_date;
	
	@JsonProperty("POC Ids")
	private String event_poc_id;
	
	@JsonProperty("Impacted Lives")
	private int lives_impacted;
	
	@JsonProperty("Total Volunteers")
	private int total_volunteers;
	
	@JsonProperty("Total Volunteer Hrs")
	private float total_volunteer_hrs;
	
	@JsonProperty("Total Travel Hrs")
	private float total_travel_hrs;
	
	@JsonProperty("Overall Volunteer Hrs")
	private float overall_volunteer_hrs;
	
//	@JsonProperty("Event Status")
//	private String event_status;
	
	@JsonProperty("IIEP Category")
	private String iiep_category;
	
	@JsonProperty("Event Council Name")
	private String event_council_name;
	
	@JsonProperty("Created By")
	private int created_by_id;
	
	@JsonProperty("Participation Count")
	private int participated_count;
	
	@JsonProperty("Unregistered Count")
	private int unregistered_count;
	
	@JsonProperty("Failed To attend Count")
	private int failed_to_attend_count;
	
	@JsonProperty("Submitted Rating Count")
	private int submitted_rating;
	
	@JsonProperty("Submitted Reason Count(RFA)")
	private int submitted_reason_rfa;
	
	@JsonProperty("Submitted Reason Count(UR)")
	private int submitted_reason_ur;

	public int getParticipated_count() {
		return participated_count;
	}

	public void setParticipated_count(int participated_count) {
		this.participated_count = participated_count;
	}

	public int getUnregistered_count() {
		return unregistered_count;
	}

	public void setUnregistered_count(int unregistered_count) {
		this.unregistered_count = unregistered_count;
	}

	public int getFailed_to_attend_count() {
		return failed_to_attend_count;
	}

	public void setFailed_to_attend_count(int failed_to_attend_count) {
		this.failed_to_attend_count = failed_to_attend_count;
	}

	public int getSubmitted_rating() {
		return submitted_rating;
	}

	public void setSubmitted_rating(int submitted_rating) {
		this.submitted_rating = submitted_rating;
	}

	public int getSubmitted_reason_rfa() {
		return submitted_reason_rfa;
	}

	public void setSubmitted_reason_rfa(int submitted_reason_rfa) {
		this.submitted_reason_rfa = submitted_reason_rfa;
	}

	public int getSubmitted_reason_ur() {
		return submitted_reason_ur;
	}

	public void setSubmitted_reason_ur(int submitted_reason_ur) {
		this.submitted_reason_ur = submitted_reason_ur;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String event_id) {
		this.eventId = event_id;
	}

	public String getEvent_base_loaction() {
		return event_base_loaction;
	}

	public void setEvent_base_loaction(String event_base_loaction) {
		this.event_base_loaction = event_base_loaction;
	}

	public String getEvent_benificiary_name() {
		return event_benificiary_name;
	}

	public void setEvent_benificiary_name(String event_benificiary_name) {
		this.event_benificiary_name = event_benificiary_name;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getEvent_description() {
		return event_description;
	}

	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}

	public String getVenue_address() {
		return venue_address;
	}

	public void setVenue_address(String venue_address) {
		this.venue_address = venue_address;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public String getEvent_poc_id() {
		return event_poc_id;
	}

	public void setEvent_poc_id(String event_poc_id) {
		this.event_poc_id = event_poc_id;
	}

	public int getLives_impacted() {
		return lives_impacted;
	}

	public void setLives_impacted(int lives_impacted) {
		this.lives_impacted = lives_impacted;
	}

	public int getTotal_volunteers() {
		return total_volunteers;
	}

	public void setTotal_volunteers(int total_volunteers) {
		this.total_volunteers = total_volunteers;
	}

	public float getTotal_volunteer_hrs() {
		return total_volunteer_hrs;
	}

	public void setTotal_volunteer_hrs(float total_volunteer_hrs) {
		this.total_volunteer_hrs = total_volunteer_hrs;
	}

	public float getTotal_travel_hrs() {
		return total_travel_hrs;
	}

	public void setTotal_travel_hrs(float total_travel_hrs) {
		this.total_travel_hrs = total_travel_hrs;
	}

	public float getOverall_volunteer_hrs() {
		return overall_volunteer_hrs;
	}

	public void setOverall_volunteer_hrs(float overall_volunteer_hrs) {
		this.overall_volunteer_hrs = overall_volunteer_hrs;
	}

	public String getIiep_category() {
		return iiep_category;
	}

	public void setIiep_category(String iiep_category) {
		this.iiep_category = iiep_category;
	}

	public String getEvent_council_name() {
		return event_council_name;
	}

	public void setEvent_council_name(String event_council_name) {
		this.event_council_name = event_council_name;
	}

	public int getCreated_by_id() {
		return created_by_id;
	}

	public void setCreated_by_id(int created_by_id) {
		this.created_by_id = created_by_id;
	}
	
}
