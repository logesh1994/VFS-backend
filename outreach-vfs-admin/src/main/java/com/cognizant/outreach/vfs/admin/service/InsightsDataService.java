package com.cognizant.outreach.vfs.admin.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.dao.model.EventRepo;
import com.cognizant.outreach.vfs.dao.model.FeedbackRepo;
import com.cognizant.outreach.vfs.dao.model.ProjectRepo;
import com.cognizant.outreach.vfs.dao.repo.EventRepository;
import com.cognizant.outreach.vfs.dao.repo.FeedbackOptionRepository;
import com.cognizant.outreach.vfs.dao.repo.FeedbackRepository;
import com.cognizant.outreach.vfs.dao.repo.RatingRepository;
import com.cognizant.outreach.vfs.domain.ChartData;
import com.cognizant.outreach.vfs.domain.DataSets;
import com.cognizant.outreach.vfs.domain.FeedbackOptions;
import com.cognizant.outreach.vfs.domain.InsightData;

@Service
public class InsightsDataService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private FeedbackOptionRepository feedbackOptionRepository;

	public InsightData getInsightsData(Date fromDate, Date toDate, String insight_level) {
		InsightData insightData = new InsightData();
		switch (insight_level) {
		case "Events":
			insightData = getEventLevelInsightData(fromDate, toDate, insight_level);
			break;
		case "Project":
			insightData = getProjectLevelInsightData(fromDate, toDate, insight_level);
			break;
		default:
			System.out.println("Inside Default case of INsights Data switch");
			break;
		}
		return insightData;
	}

	private HashMap<String, Integer> getRatingCount(List<String> event_id_list) {
		HashMap<String, Integer> ratingData = new HashMap();
		String rating;
		int value;
		if (!event_id_list.isEmpty()) {
			for (FeedbackRepo feedbackRepo : feedbackRepository.findRatingDataForEventIdAndStatus(event_id_list, "Attended")) {
				rating = feedbackRepo.getRatingBean().getDescription();
				if (!ratingData.containsKey(rating)) {
					value = 1;
				} else {
					value = ratingData.get(rating) + 1;
				}
				ratingData.put(rating, value);
			}
		}
		return ratingData;
	}
	
	private HashMap<String, Integer> getFeedbackOptionsData(List<String> event_id_list, String status) {
		HashMap<String, Integer> optionData = new HashMap();
		String option;
		int value;
		if (!event_id_list.isEmpty()) {
			for (FeedbackRepo feedbackRepo : feedbackRepository.findRatingDataForEventIdAndStatus(event_id_list, status)) {
				option = feedbackRepo.getFeedbackOption().getDescription();
				if (!optionData.containsKey(option)) {
					value = 1;
				} else {
					value = optionData.get(option) + 1;
				}
				optionData.put(option, value);
			}
		}
		return optionData;
	}
	
	private InsightData getEventLevelInsightData(Date fromDate, Date toDate, String insight_level) {
		List<String> eventIDList = new ArrayList();
		HashMap<String, Integer> tmpData = new HashMap();
		String status = null;
		
		InsightData insightData = new InsightData();
		insightData.setFrom_date(fromDate);
		insightData.setTo_date(toDate);
		insightData.setInsight_level(insight_level);
		
		DataSets dataSets = null;
		ChartData chartData = null;
		ArrayList<Integer> data = new ArrayList();
		ArrayList<DataSets> dataSetList = new ArrayList();
		ArrayList<ChartData> chartDataList = new ArrayList();
		
		eventIDList = eventRepository.findEventIdListBetweenDates(fromDate, toDate);
		chartData = new ChartData();
		chartData.setChart_type("Data Based on Rating");
		chartData.setLabels(ratingRepository.findAllDescription());
		for (String eventId: eventIDList) {
			tmpData = getRatingCount(Arrays.asList(eventId));
			dataSets = new DataSets();
			dataSets.setLabel(eventId);
			data = new ArrayList();
			for (String label: chartData.getLabels()) {
				data.add(tmpData.get(label));
			}
			dataSets.setData(data);
			dataSetList.add(dataSets);
		}
		chartData.setDatasets(dataSetList);
		chartDataList.add(chartData);
		
		chartData = new ChartData();
		chartData.setChart_type("Data of Assosiates who Failed to attend");
		chartData.setLabels(feedbackOptionRepository.findAllFeedbackOptions());
		dataSetList = new ArrayList<>();
		for (String eventId: eventIDList) {
			status = "Failed To Attend";
			tmpData = getFeedbackOptionsData(Arrays.asList(eventId), status);
			dataSets = new DataSets();
			dataSets.setLabel(eventId);
			data = new ArrayList();
			for (String label: chartData.getLabels()) {
				data.add(tmpData.get(label));
			}
			dataSets.setData(data);
			dataSetList.add(dataSets);
		}
		chartData.setDatasets(dataSetList);
		chartDataList.add(chartData);
		
		chartData = new ChartData();
		chartData.setChart_type("Data of Associates who Unregistered");
		chartData.setLabels(feedbackOptionRepository.findAllFeedbackOptions());
		dataSetList = new ArrayList<>();
		for (String eventId: eventIDList) {
			status = "Unregistered";
			tmpData = getFeedbackOptionsData(Arrays.asList(eventId), status);
			dataSets = new DataSets();
			dataSets.setLabel(eventId);
			data = new ArrayList();
			for (String label: chartData.getLabels()) {
				data.add(tmpData.get(label));
			}
			dataSets.setData(data);
			dataSetList.add(dataSets);
		}
		chartData.setDatasets(dataSetList);
		chartDataList.add(chartData);
		
		insightData.setChart_data(chartDataList);
		return insightData;
	}
	
	private InsightData getProjectLevelInsightData(Date fromDate, Date toDate, String insight_level) {
		List<EventRepo> eventList = new ArrayList();
		HashMap<String, String> projectMap = new HashMap();
		HashMap<String, Integer> tmpData = new HashMap();
		String status = null;
		
		InsightData insightData = new InsightData();
		insightData.setFrom_date(fromDate);
		insightData.setTo_date(toDate);
		insightData.setInsight_level(insight_level);
		
		DataSets dataSets = null;
		ChartData chartData = null;
		ArrayList<Integer> data = new ArrayList();
		ArrayList<DataSets> dataSetList = new ArrayList();
		ArrayList<ChartData> chartDataList = new ArrayList();
		String projectName = null;
		String tmp;
		
		eventList = eventRepository.findEventListBetweenDates(fromDate, toDate);
		for (EventRepo repo : eventList) {
			projectName = repo.getProject().getDescription();
			if (!projectMap.containsKey(projectName)) {
				tmp = repo.getId();
			} else {
				tmp = projectMap.get(projectName) + "," + repo.getId();
			}
			projectMap.put(projectName, tmp);
		}
		
		chartData = new ChartData();
		chartData.setChart_type("Data Based on Rating");
		chartData.setLabels(ratingRepository.findAllDescription());
		for (String project: projectMap.keySet()) {
			tmpData = getRatingCount(Arrays.asList(projectMap.get(project).split(",")));
			dataSets = new DataSets();
			dataSets.setLabel(project);
			data = new ArrayList();
			for (String label: chartData.getLabels()) {
				data.add(tmpData.get(label));
			}
			dataSets.setData(data);
			dataSetList.add(dataSets);
		}
		chartData.setDatasets(dataSetList);
		chartDataList.add(chartData);
		
		chartData = new ChartData();
		chartData.setChart_type("Data of Assosiates who Failed to attend");
		chartData.setLabels(feedbackOptionRepository.findAllFeedbackOptions());
		dataSetList = new ArrayList<>();
		for (String project: projectMap.keySet()) {
			status = "Failed To Attend";
			tmpData = getFeedbackOptionsData(Arrays.asList(projectMap.get(project).split(",")), status);
			dataSets = new DataSets();
			dataSets.setLabel(project);
			data = new ArrayList();
			for (String label: chartData.getLabels()) {
				data.add(tmpData.get(label));
			}
			dataSets.setData(data);
			dataSetList.add(dataSets);
		}
		chartData.setDatasets(dataSetList);
		chartDataList.add(chartData);
		
		chartData = new ChartData();
		chartData.setChart_type("Data of Associates who Unregistered");
		chartData.setLabels(feedbackOptionRepository.findAllFeedbackOptions());
		dataSetList = new ArrayList<>();
		for (String project: projectMap.keySet()) {
			status = "Unregistered";
			tmpData = getFeedbackOptionsData(Arrays.asList(projectMap.get(project).split(",")), status);
			dataSets = new DataSets();
			dataSets.setLabel(project);
			data = new ArrayList();
			for (String label: chartData.getLabels()) {
				data.add(tmpData.get(label));
			}
			dataSets.setData(data);
			dataSetList.add(dataSets);
		}
		chartData.setDatasets(dataSetList);
		chartDataList.add(chartData);
		
		insightData.setChart_data(chartDataList);
		return insightData;
	}
	
}
