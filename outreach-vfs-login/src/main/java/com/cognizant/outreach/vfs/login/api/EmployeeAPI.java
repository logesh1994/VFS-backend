package com.cognizant.outreach.vfs.login.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.outreach.vfs.domain.Employee;
import com.cognizant.outreach.vfs.login.service.EmployeeService;
import com.cognizant.outreach.vfs.util.*;
import com.cognizant.outreach.vfs.api.response.*;

@RestController
@RequestMapping(ReqMapConstants.LOGIN)
public class EmployeeAPI extends APIUtil {
	
	private static final Logger logger = LogManager.getLogger(EmployeeAPI.class.getName());
	
	@Autowired
	protected EmployeeService employeeService;

    @RequestMapping(value = ReqMapConstants.LOGIN_AUTHENTICATE, 
    		method = RequestMethod.POST, produces = ReqMapConstants.CHARSET)
    public String login(@RequestParam String loginId, @RequestParam String password, @RequestParam Boolean keepMeLogin) {

        if ("".equals(loginId) || "".equals(password)) {
            statusResponse = new StatusResponse<Object>(APIStatus.INVALID_PARAMETER);
        } else {
            Employee employeeLogin = employeeService.getEmployeeByLoginId(Integer.parseInt(loginId));

            if (employeeLogin != null) {
                if (employeeLogin.getStatusId().equalsIgnoreCase("ACTIVE")) {//Active
                    if (password.equals(employeeLogin.getPassword())) {
                        statusResponse = new StatusResponse<>(HttpStatus.OK.value());
                        logger.debug("Transaction Name = login, Status = SUCCESS, " + employeeLogin.getEmployeeId());
                    } else {
                        // wrong password
                        statusResponse = new StatusResponse<Object>(APIStatus.ERR_EMP_NOT_VALID);
                    }
                } else {
                    statusResponse = new StatusResponse<Object>(APIStatus.ERR_EMP_NOT_VALID);
                }
            } else {
                statusResponse = new StatusResponse<Object>(APIStatus.ERR_EMP_NOT_EXIST);
            }
        }

        return writeObjectToJson(statusResponse);
    }

    @RequestMapping(value = "/test/{id}/{pass}", 
    		method = RequestMethod.GET, produces = ReqMapConstants.CHARSET)
    public String loginTest(@PathVariable("id") int loginId, @PathVariable("pass") String password) {
    	String responseString = "Login-Id: " + loginId + " Pass: " + password;
    	Employee employeeLogin = employeeService.getEmployeeByLoginId(loginId);
    	StatusResponse response = new StatusResponse();
    	response.setResult(employeeLogin);
    	response.setStatus(APIStatus.OK);
    	return writeObjectToJson(response);
    }
}
