package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChartData implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("chartType")
    private String chart_type;
    
    @JsonProperty("labels")
    private List<String> labels;
    
    @JsonProperty("datasets")
    private List<DataSets> datasets;

	public String getChart_type() {
		return chart_type;
	}

	public void setChart_type(String chart_type) {
		this.chart_type = chart_type;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<DataSets> getDatasets() {
		return datasets;
	}

	public void setDatasets(List<DataSets> datasets) {
		this.datasets = datasets;
	}   

}
