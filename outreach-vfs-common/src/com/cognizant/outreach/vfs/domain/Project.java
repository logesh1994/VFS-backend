package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Project Id")
    private int project_id;
    
    @JsonProperty("Project Name")
    private String project_name;

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

}
