package com.cognizant.outreach.vfs.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.beanutils.EmployeeBeanUtils;
import com.cognizant.outreach.vfs.config.AppConfig;
import com.cognizant.outreach.vfs.dao.model.EmployeeRepo;
import com.cognizant.outreach.vfs.dao.repo.EmployeeRepository;
import com.cognizant.outreach.vfs.domain.Employee;


@Service
public class EmployeeService {
	
	@Autowired
	protected AppConfig appConfig;

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee getEmployeeByLoginId(int loginId) {
    	EmployeeRepo employeeRepo = employeeRepository.findByLoginId(loginId);
    	return EmployeeBeanUtils.getEmployee(employeeRepo, new Employee());
    }
    
}