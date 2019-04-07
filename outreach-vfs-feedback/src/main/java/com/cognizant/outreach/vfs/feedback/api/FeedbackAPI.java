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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(ReqMapConstants.FEEDBACK)
@Api(value="VFS Feedback MicroService")
public class FeedbackAPI extends APIUtil {

	private static final Logger logger = LogManager.getLogger(FeedbackAPI.class.getName());

	@Autowired
	protected FeedbackService feedbackService;

	@ApiOperation(value = "Retrieve the Appropriate Feedback Template")
	@RequestMapping(value = ReqMapConstants.RETRIEVE_FEEDBACK_TEMPLATE, method = RequestMethod.POST, produces = ReqMapConstants.CHARSET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request")})
	public String retrieveFeedbackTemplate(@RequestBody FeedbackTemplate request) {
		StatusResponse<FeedbackTemplate> response = new StatusResponse<FeedbackTemplate>();
		try {
			int event_detail_id = Integer.parseInt(request.getEvent_id());
			int employee_id = Integer.parseInt(request.getEmployee_id());

			FeedbackTemplate feedbackTemplate = feedbackService.getFeedbackTemplateData(event_detail_id, employee_id);
			if (feedbackTemplate == null) {
				response.setStatus(APIStatus.BAD);
			} else {
				response.setResult(feedbackTemplate);
				response.setStatus(APIStatus.OK);
			}
		} catch (Exception e) {
			response.setStatus(APIStatus.BAD);
		} finally {
			return writeObjectToJson(response);
		}
	}

	@ApiOperation(value = "Save feedback data")
	@RequestMapping(value = ReqMapConstants.SAVE_FEEDBACK, method = RequestMethod.POST, produces = ReqMapConstants.CHARSET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request")})
	public String saveFeedback(@RequestBody Feedback request) {
		StatusResponse<FeedbackTemplate> response = new StatusResponse<FeedbackTemplate>();
		try {
			response.setResult(feedbackService.saveFeedbackData(request));
			response.setStatus(APIStatus.OK);
		} catch (Exception e) {
			response.setStatus(APIStatus.BAD);
		} finally {
			return writeObjectToJson(response);
		}	
	}

}
