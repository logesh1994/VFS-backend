package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminUpdateData implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("tableName")
    private String table_name;
    
    @JsonProperty("data")
    private ArrayList<?> data;
    
    @JsonProperty("action")
    private String action;

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public ArrayList<?> getData() {
		return data;
	}

	public void setData(ArrayList<?> data) {
		this.data = data;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "AdminUpdateData [AdminUpdateDatatable_name=" + table_name + ", AdminUpdateDatadata=" + data + ", AdminUpdateDataaction=" + action + "]";
	}
	
	

}
