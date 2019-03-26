package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsightData implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Insights Level")
    private String insight_level;
    
	@JsonProperty("From Date")
    private Date from_date;
	
	@JsonProperty("To Date")
    private Date to_date;
	
	@JsonProperty("Employee Id")
	private int employee_id;
	
	@JsonProperty("chartData")	
	private List<ChartData> chart_data;
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public List<ChartData> getChart_data() {
		return chart_data;
	}

	public void setChart_data(List<ChartData> chart_data) {
		this.chart_data = chart_data;
	}

	public String getInsight_level() {
		return insight_level;
	}

	public void setInsight_level(String insight_level) {
		this.insight_level = insight_level;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

}