package com.cognizant.outreach.vfs.login.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.outreach.vfs.dao.model.EmployeeRepo;
import com.cognizant.outreach.vfs.dao.model.RoleLookupRepo;
import com.cognizant.outreach.vfs.dao.repo.EmployeeRepository;
import com.cognizant.outreach.vfs.domain.Employee;
import com.cognizant.outreach.vfs.util.Constants;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

	 @TestConfiguration
	    static class EmployeeServiceTestContextConfiguration {
	  
	        @Bean
	        public EmployeeService employeeService() {
	            return new EmployeeService();
	        }
	    }
	 
	 @Autowired
	 private EmployeeService employeeService;
	 
	 @MockBean
	 private EmployeeRepository employeeRepository;
	 
	 @Before
	 public void setUp() {
		 int id = 500000;
	     EmployeeRepo testEmployee = new EmployeeRepo(id, id + Constants.COGNIZANT_MAIL, new RoleLookupRepo("Admin"));
	     Mockito.when(employeeRepository.findByLoginId(id))
	       .thenReturn(testEmployee);
	 }
	 
	 @Test
	 public void testGetEmployeeByLoginId() {
		 Employee employee =  employeeService.getEmployeeByLoginId(500000);
		 Assert.assertEquals(employee.getEmployeeId(), 500000); 
	 }
}
