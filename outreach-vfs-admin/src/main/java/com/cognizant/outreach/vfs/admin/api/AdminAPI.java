package com.cognizant.outreach.vfs.admin.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.outreach.vfs.admin.service.AdminTablesDataService;
import com.cognizant.outreach.vfs.admin.service.EmailBatchService;
import com.cognizant.outreach.vfs.admin.service.EventAndFeedBackDataService;
import com.cognizant.outreach.vfs.admin.service.InsightsDataService;
import com.cognizant.outreach.vfs.api.response.APIStatus;
import com.cognizant.outreach.vfs.api.response.StatusResponse;
import com.cognizant.outreach.vfs.dao.model.EmployeeRepo;
import com.cognizant.outreach.vfs.dao.repo.EmployeeRepository;
import com.cognizant.outreach.vfs.domain.AdminUpdateData;
import com.cognizant.outreach.vfs.domain.ChartData;
import com.cognizant.outreach.vfs.domain.DataSets;
import com.cognizant.outreach.vfs.domain.InsightData;
import com.cognizant.outreach.vfs.service.AdminDataUpdateService;
import com.cognizant.outreach.vfs.util.APIUtil;
import com.cognizant.outreach.vfs.util.ReqMapConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(ReqMapConstants.ADMIN)
@Api(value="VFS Admin MicroService")
public class AdminAPI extends APIUtil {

	private static final Logger logger = LogManager.getLogger(AdminAPI.class.getName());

	@Autowired
	private AdminTablesDataService adminService;

	@Autowired
	private EventAndFeedBackDataService eventAndFeedBackDataService;

	@Autowired
	private AdminDataUpdateService adminDataUpdateService;

	@Autowired
	private InsightsDataService insightsDataService;

	@Autowired
	private EmailBatchService emailBatchService;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@SuppressWarnings("finally")
	@ApiOperation(value = "Retrieve Admin Table data")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request")})
	@RequestMapping(value = ReqMapConstants.GET_ADMIN_DATA, method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
	public String getAdminData() {
		StatusResponse<List<?>> response = new StatusResponse<List<?>>();
		try {
			response.setResult(adminService.getAllAdminTableData());
			response.setStatus(APIStatus.OK);
		} catch (Exception e) {
			response.setStatus(APIStatus.BAD);

		} finally {
			return writeObjectToJson(response);
		}
	}

	@SuppressWarnings("finally")
	@ApiOperation(value = "Retrieve Event Details and Feedback data based on Access")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request")})
	@RequestMapping(value = ReqMapConstants.GET_EVENTDETAILS_DATA, method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
	public String getEventDetailsAndFeedbackData(@PathVariable("employeeId") String employeeId) {
		StatusResponse<List<?>> response = new StatusResponse<List<?>>();
		try {
			EmployeeRepo employee = employeeRepository.findByLoginId(Integer.parseInt(employeeId));
			if (employee != null && employee.getRoleLookup() != null &&
					(employee.getRoleLookup().getDescription().equals("Admin") ||
							employee.getRoleLookup().getDescription().equals("POC"))) {
				response.setResult(eventAndFeedBackDataService.getEventDetailsAndFeedbackDetails(employeeId, employee.getRoleLookup().getDescription()));
				response.setStatus(APIStatus.OK);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(APIStatus.BAD);
		} finally {
			return writeObjectToJson(response);
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@ApiOperation(value = "Update Admin Table Data Based on Specified Action ADD or EDIT including Bulk Addition")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request")})
	@RequestMapping(value = ReqMapConstants.UPDATE_ADMIN_DATA, method = RequestMethod.POST, produces = ReqMapConstants.CHARSET)
	public String updateAdminData(@RequestBody AdminUpdateData payload) {
		StatusResponse<?> response = new StatusResponse();
		List<Map<String, String>> data = new ArrayList<>();
		try {
			for (Object object : payload.getData()) {
				System.out.println(object);
				data.add((Map<String, String>) object);
			}
			adminDataUpdateService.updateAdminData(payload.getTable_name(), data, payload.getAction());
			response.setStatus(APIStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(APIStatus.BAD);
		} finally {
			return writeObjectToJson(response);
		}
	}

	@SuppressWarnings("finally")
	@ApiOperation(value = "Retrieve Insight Data based on access")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request")})
	@RequestMapping(value = ReqMapConstants.GET_INSIGHT_DATA, method = RequestMethod.POST, produces = ReqMapConstants.CHARSET)
	public String getInsightData(@RequestBody InsightData payload) {
		StatusResponse<InsightData> response = new StatusResponse<InsightData>();
		try {
			EmployeeRepo employee = employeeRepository.findByLoginId (payload.getEmployee_id());
			if (employee != null && employee.getRoleLookup() != null &&
					(employee.getRoleLookup().getDescription().equals("Admin") ||
							employee.getRoleLookup().getDescription().equals("POC"))) {
				InsightData insightData = new InsightData();
				response.setResult(insightsDataService.getInsightsData(payload.getFrom_date(), payload.getTo_date(),
						payload.getInsight_level(), payload.getEmployee_id(), employee.getRoleLookup().getDescription()));
				response.setStatus(APIStatus.OK);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(APIStatus.BAD);
		} finally {
			return writeObjectToJson(response);
		}	
	}

	@SuppressWarnings({"finally" })
	@ApiOperation(value = "Retrieve Event Summary Data")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request")})
	@RequestMapping(value = ReqMapConstants.GET_EVENT_SUMMARY_DATA, method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
	public String getEventIdList() {	
		StatusResponse<List<?>> response = new StatusResponse<List<?>>();
		try {
			response.setResult(adminService.getEventLookUpData());
			response.setStatus(APIStatus.OK);
		} catch (Exception e) {
			response.setStatus(APIStatus.BAD);

		} finally {
			return writeObjectToJson(response);
		}
	}

	@SuppressWarnings("finally")
	@ApiOperation(value = "Trigger Feedback Email Batch or Reminder Batch")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request")})
	@RequestMapping(value = ReqMapConstants.TRIGGER_EMAIL_BATCH, method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
	public String triggerEmailBatch(@PathVariable("eventId") String eventId,
			@PathVariable("isReminder") String isReminder) {
		StatusResponse<String> response = new StatusResponse<String>();
		try {
			emailBatchService.triggerEmailBatch(eventId, isReminder);
			response.setResult("Email Batch Triggered Successfully");
			response.setStatus(APIStatus.OK);
		} catch (Exception e) {
			response.setStatus(APIStatus.BAD);
		} finally {
			return writeObjectToJson(response);
		}
	}
}
