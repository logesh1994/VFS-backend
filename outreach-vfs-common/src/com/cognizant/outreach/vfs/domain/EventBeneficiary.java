package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventBeneficiary implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Beneficiary Id")
    private int event_benificiary_id;
    
    @JsonProperty("Beneficiary Name")
    private String event_benificiary_name;
    
	public int getEvent_benificiary_id() {
		return event_benificiary_id;
	}
	public void setEvent_benificiary_id(int event_benificiary_id) {
		this.event_benificiary_id = event_benificiary_id;
	}
	public String getEvent_benificiary_name() {
		return event_benificiary_name;
	}
	public void setEvent_benificiary_name(String event_benificiary_name) {
		this.event_benificiary_name = event_benificiary_name;
	}
    
}
