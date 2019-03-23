package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Location Id")
    private int location_id;
    
    @JsonProperty("City")
    private String city_name;
    
    @JsonProperty("State")
    private String state_name;
    
    @JsonProperty("Country")
    private String country_name;

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
    
	
}
