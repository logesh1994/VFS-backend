package com.cognizant.outreach.vfs.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AdminTableUtils {

	@SuppressWarnings("serial")
	public static final HashMap<String, List<String>> ADMIN_TABLE_COLUMN_MAP = new HashMap<String, List<String>>() {{
		        put("Business Unit", Arrays.asList("Business Unit Id", "Business Unit Name", "Location"));
		        put("Location", Arrays.asList("Location Id", "City", "State", "Country"));
		        put("Event Beneficiary", Arrays.asList("Beneficiary Id", "Beneficiary Name"));
		        put("Event Council", Arrays.asList("Event Council Id", "Event Council Name"));
		        put("Feedback Options", Arrays.asList("Option Id", "Description"));
		        put("IIEP Category", Arrays.asList("IIEP Category Id", "IIEP Category Name"));
		        put("Role", Arrays.asList("Role Id", "Role"));
		        put("Rating", Arrays.asList("Rating Id", "Value"));
		        put("Status", Arrays.asList("Status Id", "Value"));
		        put("Project", Arrays.asList("Project Id", "Project Name"));
		        put("Category", Arrays.asList("Category Id", "Category Name"));
		        put("Event", Arrays.asList("Event Id","Location","Beneficiary Name","Event Name","Month","Project","Category","Event Description","Venue Address","Event Date"
		        		,"POC Ids","Impacted Lives","Total Volunteers","Total Volunteer Hrs","Total Travel Hrs","Overall Volunteer Hrs","IIEP Category","Event Council Name","Created By"));
		        put("Employee", Arrays.asList("Employee Id", "Role", "Email", "First Name","Last Name", "Contact","Location", "Business Unit","Status Id"));
		        put("Event Details", Arrays.asList("Event Details Id","Event Id","Employee Id","Volunteer Hours","Travel Hours","Participation Status","Feedback Status","Created By"));
		        put("Feedback", Arrays.asList("Feedback Id", "Event Detail Id","Rating","Reason","Positives","Suggested Improvements","Admin Feedback","Updated By"));
		    }};
}
