package com.cognizant.outreach.vfs.feedback.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.outreach.vfs.api.response.APIStatus;
import com.cognizant.outreach.vfs.api.response.StatusResponse;
import com.cognizant.outreach.vfs.domain.Feedback;
import com.cognizant.outreach.vfs.domain.FeedbackTemplate;
import com.cognizant.outreach.vfs.feedback.service.FeedbackService;
import com.cognizant.outreach.vfs.util.APIUtil;
import com.cognizant.outreach.vfs.util.ReqMapConstants;

@RestController
@RequestMapping(ReqMapConstants.FEEDBACK)
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackAPI extends APIUtil{

private static final Logger logger = LogManager.getLogger(FeedbackAPI.class.getName());
	
	@Autowired
	protected FeedbackService feedbackService;
	
	@RequestMapping(value = ReqMapConstants.RETRIEVE_FEEDBACK_TEMPLATE, method = RequestMethod.POST
			, produces = ReqMapConstants.CHARSET)
    public String retrieveFeedbackTemplate(@RequestBody FeedbackTemplate request) {
		int event_detail_id = Integer.parseInt(request.getEvent_id());
		int employee_id = Integer.parseInt(request.getEmployee_id());
		StatusResponse response = new StatusResponse();
		response.setResult(feedbackService.getFeedbackTemplateData(event_detail_id, employee_id));
		response.setStatus(APIStatus.OK);
		System.out.println(feedbackService.getFeedbackTemplateData(event_detail_id, employee_id));
		return writeObjectToJson(response);
		//TODO INT Parse exception Handling
//		statusResponse = new StatusResponse<Object>(APIStatus.UNAUTH);
	}
	
	@RequestMapping(value = ReqMapConstants.SAVE_FEEDBACK, method = RequestMethod.POST
			, produces = ReqMapConstants.CHARSET)
    public String saveFeedback(@RequestBody Feedback request) {
		StatusResponse response = new StatusResponse();
		response.setResult(feedbackService.saveFeedbackData(request));
		response.setStatus(APIStatus.OK);
		return writeObjectToJson(response);
		//TODO INT Parse exception Handling
//		statusResponse = new StatusResponse<Object>(APIStatus.UNAUTH);
	}

	
}
