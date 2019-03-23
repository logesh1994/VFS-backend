package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminTableData implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("tableName")
    private String tableName;
    
    @JsonProperty("columnNames")
    private List<String> columnNames;
    
    private List<?> data;

	public AdminTableData(String tableName, List<String> columnNames, List<?> data) {
		super();
		this.tableName = tableName;
		this.columnNames = columnNames;
		this.data = data;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

}
