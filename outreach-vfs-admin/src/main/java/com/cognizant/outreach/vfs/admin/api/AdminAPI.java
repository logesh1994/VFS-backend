package com.cognizant.outreach.vfs.admin.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.outreach.vfs.admin.service.AdminTablesDataService;
import com.cognizant.outreach.vfs.admin.service.EventAndFeedBackDataService;
import com.cognizant.outreach.vfs.api.response.APIStatus;
import com.cognizant.outreach.vfs.api.response.StatusResponse;
import com.cognizant.outreach.vfs.domain.AdminUpdateData;
import com.cognizant.outreach.vfs.service.AdminDataUpdateService;
import com.cognizant.outreach.vfs.util.APIUtil;
import com.cognizant.outreach.vfs.util.ReqMapConstants;

@RestController
@RequestMapping(ReqMapConstants.ADMIN)
@CrossOrigin(origins = "http://localhost:4200")
public class AdminAPI extends APIUtil {
	
	private static final Logger logger = LogManager.getLogger(AdminAPI.class.getName());
	
	@Autowired
	private AdminTablesDataService adminService;
	
	@Autowired
	private EventAndFeedBackDataService eventAndFeedBackDataService;
	
	@Autowired
	private AdminDataUpdateService adminDataUpdateService;
	

    @RequestMapping(value = ReqMapConstants.GET_ADMIN_DATA, 
    		method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
    public String getAdminData() {
    	//TODO add try catch
    	StatusResponse response = new StatusResponse();
    	response.setResult(adminService.getAllAdminTableData());
    	response.setStatus(APIStatus.OK);
    	return writeObjectToJson(response);
    }
    
    @RequestMapping(value = ReqMapConstants.GET_EVENTDETAILS_DATA, 
    		method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
    public String getEventDetailsAndFeedbackData() {
    	//TODO add try catch
    	StatusResponse response = new StatusResponse();
    	response.setResult(eventAndFeedBackDataService.getEventDetailsAndFeedbackDetails());
    	response.setStatus(APIStatus.OK);
    	return writeObjectToJson(response);
    }
    
    @RequestMapping(value = ReqMapConstants.UPDATE_ADMIN_DATA, 
    		method = RequestMethod.POST, produces = ReqMapConstants.CHARSET)
    public String updateAdminData(@RequestBody AdminUpdateData payload) {
    	//TODO add try catch
    	System.out.println(payload);
    	StatusResponse response = new StatusResponse();
    	List<Map<String, String>> data = new ArrayList<>();
    	try {
    		for (Object object: payload.getData()) {
    			System.out.println(object);
    			data.add((Map<String, String>) object);
    		}
    		adminDataUpdateService.updateAdminData(payload.getTable_name(), data, payload.getAction());
			response.setStatus(APIStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(APIStatus.BAD);
		}
    	return writeObjectToJson(response);
    }


}
