package com.cognizant.outreach.vfs.login.api;

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
import com.cognizant.outreach.vfs.domain.Employee;
import com.cognizant.outreach.vfs.login.service.EmployeeService;
import com.cognizant.outreach.vfs.util.APIUtil;
import com.cognizant.outreach.vfs.util.ReqMapConstants;

@RestController
@RequestMapping(ReqMapConstants.LOGIN)
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeAPI extends APIUtil {

	private static final Logger logger = LogManager.getLogger(EmployeeAPI.class.getName());

	@Autowired
	protected EmployeeService employeeService;

	@RequestMapping(value = ReqMapConstants.LOGIN_AUTHENTICATE, method = RequestMethod.POST, produces = ReqMapConstants.CHARSET)
	public String authenticate(@RequestBody Employee employee) {
		StatusResponse response = new StatusResponse();
		if ("".equals(employee.getPassword()) || employee.getEmployeeId() == 0) {
			response.setStatus(APIStatus.INVALID_PARAMETER);
		} else {
			Employee employeeLogin = employeeService.getEmployeeByLoginId(employee.getEmployeeId());

			if (employeeLogin == null || employeeLogin.getPassword() == null) {
				response.setStatus(APIStatus.ERR_EMP_NOT_EXIST);
			} else if (employeeLogin.getStatusId().equalsIgnoreCase("Active")) {// Active
				if (employee.getPassword().equals(employeeLogin.getPassword())) {
					employeeLogin.setPassword(null);
					response.setResult(employeeLogin);
					response.setStatus(APIStatus.OK);
					logger.debug("Transaction Name = login, Status = SUCCESS, " + employeeLogin.getEmployeeId());
				} else {
					// wrong password
					response.setStatus(APIStatus.ERR_EMP_NOT_VALID);
				}
			}
		}
		return writeObjectToJson(response);
	}
}
