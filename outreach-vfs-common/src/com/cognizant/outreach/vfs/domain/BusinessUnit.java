package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BusinessUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Business Unit Id")
    private int business_unit_id;
    
    @JsonProperty("Business Unit Name")
    private String business_unit_name;
    
    @JsonProperty("Location")
    private String business_unit_location;
    
	public BusinessUnit(int business_unit_id, String business_unit_name, String business_unit_location) {
		super();
		this.business_unit_id = business_unit_id;
		this.business_unit_name = business_unit_name;
		this.business_unit_location = business_unit_location;
	}
	
	public BusinessUnit() {
		// TODO Auto-generated constructor stub
	}

	public int getBusiness_unit_id() {
		return business_unit_id;
	}
	public void setBusiness_unit_id(int business_unit_id) {
		this.business_unit_id = business_unit_id;
	}
	public String getBusiness_unit_name() {
		return business_unit_name;
	}
	public void setBusiness_unit_name(String business_unit_name) {
		this.business_unit_name = business_unit_name;
	}
	public String getBusiness_unit_location() {
		return business_unit_location;
	}
	public void setBusiness_unit_location(String business_unit_location) {
		this.business_unit_location = business_unit_location;
	}
    
}
