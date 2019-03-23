package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventCouncil implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("Event Council Id")
    private int event_council_id;
    
    @JsonProperty("Event Council Name")
    private String event_council_name;
    
    @JsonProperty("Location")
    private String location_name;
    
	public int getEvent_council_id() {
		return event_council_id;
	}
	public void setEvent_council_id(int event_council_id) {
		this.event_council_id = event_council_id;
	}
	public String getEvent_council_name() {
		return event_council_name;
	}
	public void setEvent_council_name(String event_council_name) {
		this.event_council_name = event_council_name;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
   
}
