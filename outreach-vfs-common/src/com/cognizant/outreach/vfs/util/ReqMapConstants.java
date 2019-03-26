package com.cognizant.outreach.vfs.util;

public class ReqMapConstants {
	
	// version
    public static final String VFS = "vfs";
	
	// version
    public static final String VERSION = "/api/v1";
    
    // charset
    public static final String CHARSET = "application/json;charset=utf-8";
	
	//Login API
    public static final String LOGIN = VFS+VERSION + "/login";
	public static final String LOGIN_AUTHENTICATE = "/authenticate";
	
	//Feedback API
    public static final String FEEDBACK = VFS+VERSION + "/feedback";
    public static final String RETRIEVE_FEEDBACK_TEMPLATE = "/getFeedbackTemplate";
	public static final String SAVE_FEEDBACK = "/saveFeedback";
    
    //GeneralReq API
    public static final String GENERAL = VFS+VERSION + "/general";
    
  //Admin API
    public static final String ADMIN = VFS+VERSION + "/admin";
	public static final String GET_ADMIN_DATA = "/getAdminData";
	public static final String GET_EVENTDETAILS_DATA = "/getEventDetailsData/{employeeId}";
	public static final String UPDATE_ADMIN_DATA = "/updateAdminData";
	public static final String GET_INSIGHT_DATA = "/getInsights";
	public static final String GET_EVENT_SUMMARY_DATA = "/getEventDataList";
	public static final String TRIGGER_EMAIL_BATCH = "/triggerEmailBatch/{eventId}/{isReminder}";

//	//Admin API
//    public static final String VFS_BATCH = VFS+VERSION + "/vfsBatch";
//	public static final String TRIGGER_EMAIL_BATCH = "/triggerEmailBatch/{eventId}";

} 