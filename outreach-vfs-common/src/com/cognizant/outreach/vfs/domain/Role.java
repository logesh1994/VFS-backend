package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Role Id")
    private int role_id;
    
    @JsonProperty("Role")
    private String role;
    
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
    

}
