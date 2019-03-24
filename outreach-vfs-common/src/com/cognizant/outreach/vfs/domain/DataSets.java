package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataSets implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("data")
    private List<Integer> data;
    
    @JsonProperty("label")
    private String label;

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
