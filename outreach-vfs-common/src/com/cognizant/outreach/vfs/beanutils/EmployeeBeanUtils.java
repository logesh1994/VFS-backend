package com.cognizant.outreach.vfs.beanutils;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.outreach.vfs.dao.model.EmployeeRepo;
import com.cognizant.outreach.vfs.dao.model.RoleLookupRepo;
import com.cognizant.outreach.vfs.domain.Employee;

public final class EmployeeBeanUtils {
	
	public static Employee getEmployee(EmployeeRepo employeeRepo, Employee employee) {
		if (employeeRepo != null) {
			employee = new Employee();
			employee.setEmployeeId(employeeRepo.getEmployeeId());
			employee.setEmail(employeeRepo.getEmpEmail());
			employee.setFirst_name(employeeRepo.getEmpFirstName());
			employee.setLast_name(employeeRepo.getEmpLastName());
			if(employeeRepo.getStatus() != null) {
				employee.setStatusId(employeeRepo.getStatus().getDescription());
			}
			if(employeeRepo.getRoleLookup() != null) {
				employee.setRole(employeeRepo.getRoleLookup().getDescription());
			}
			//TODO Password Field to deviated into another flow
			employee.setPassword(employeeRepo.getPassword());
			employee.setIs_valid_user(true);
			employee.setCreateDate(employeeRepo.getCreateTimestamp());
			employee.setContact(employeeRepo.getContact());
			if(employeeRepo.getBusinessUnit() != null) {
				employee.setBu_unit(employeeRepo.getBusinessUnit().getBussUnitName());
			}
			if(employeeRepo.getLocation() != null) {
				employee.setLocation(employeeRepo.getLocation().getCity());
			}	
		}
		return employee;
	}
	
	public static EmployeeRepo getEmployeeRepo(Employee employee) {
		EmployeeRepo employeeRepo = null;
		if(employee != null) {
			employeeRepo = new EmployeeRepo();
			RoleLookupRepo roleLookupRepo = new RoleLookupRepo();
			employeeRepo.setEmployeeId(employeeRepo.getEmployeeId());
			employeeRepo.setEmpEmail(employeeRepo.getEmpEmail());
			employeeRepo.setEmpFirstName(employee.getFirst_name());
			employeeRepo.setEmpLastName(employee.getLast_name());
		//	employee.setStatusId();
			//TODO role Look up Logic
//			roleLookupRepo.set
//			employeeRepo.setRoleLookup(employee.getRole());
			employeeRepo.setPassword(employee.getPassword());
			employeeRepo.setContact(employee.getContact());
		}
		return employeeRepo;
	}
	
	public static List<Employee> getEmployeeList(List<EmployeeRepo> employeeRepoList) {
		List<Employee> employeeList = new ArrayList<>();
		Employee employee = null;
		for (EmployeeRepo employeeRepo: employeeRepoList) {
			employee = getEmployee(employeeRepo, employee);
			employeeList.add(employee);
		}
		return employeeList;
	}

}
