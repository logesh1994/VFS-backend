package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IiepCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("IIEP Category Id")
    private int iiep_category_id;
    
    @JsonProperty("IIEP Category Name")
    private String iiep_category_name;
    
	public int getIiep_category_id() {
		return iiep_category_id;
	}
	public void setIiep_category_id(int iiep_category_id) {
		this.iiep_category_id = iiep_category_id;
	}
	public String getIiep_category_name() {
		return iiep_category_name;
	}
	public void setIiep_category_name(String iiep_category_name) {
		this.iiep_category_name = iiep_category_name;
	}
    
}
