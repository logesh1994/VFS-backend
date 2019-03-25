package com.cognizant.outreach.vfs.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Employee Id")
    private int employeeId;
    
    @JsonProperty("Role")
    private String role;
    
    @JsonProperty("Email")
    private String email;
    
    @JsonProperty("Contact")
    private String contact;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Password")
    private String password;
    
    @JsonProperty("First Name")
    private String first_name;
    
    @JsonProperty("Last Name")
    private String last_name;
    
    @JsonProperty("Status Id")
    private String statusId;
    
    @JsonProperty("Create Date")
    private Date createDate;
    
    @JsonProperty("Volunteer hours")
    private float volunteer_hours;
    
    @JsonProperty("Business Unit")
    private String bu_unit;
    
    @JsonProperty("Location")
    private String location;
    
    @JsonProperty("isValidUser")
    private boolean is_valid_user;
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public float getVolunteer_hours() {
		return volunteer_hours;
	}
	public void setVolunteer_hours(float volunteer_hours) {
		this.volunteer_hours = volunteer_hours;
	}
	
	public String getBu_unit() {
		return bu_unit;
	}
	public void setBu_unit(String bu_unit) {
		this.bu_unit = bu_unit;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isIs_valid_user() {
		return is_valid_user;
	}
	public void setIs_valid_user(boolean is_valid_user) {
		this.is_valid_user = is_valid_user;
	}
    
}