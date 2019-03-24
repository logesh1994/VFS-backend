package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="EmployeeRepo.findAll", query="SELECT e FROM EmployeeRepo e")
public class EmployeeRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="employee_id")
	private int employeeId;

	private String contact;

	@Column(name="create_timestamp")
	private Timestamp createTimestamp;

	@Column(name="emp_email")
	private String empEmail;

	@Column(name="emp_first_name")
	private String empFirstName;

	@Column(name="emp_last_name")
	private String empLastName;

	@Column(name="evnt_volunteer_hours")
	private float evntVolunteerHours;

	@Column(name="last_login")
	private Timestamp lastLogin;

	private String password;

	//bi-directional many-to-one association to BusinessUnitRepo
	@ManyToOne
	@JoinColumn(name="business_unit_id")
	private BusinessUnitRepo businessUnit;

	//bi-directional many-to-one association to LocationRepo
	@ManyToOne
	@JoinColumn(name="emp_location_id")
	private LocationRepo location;

	//bi-directional many-to-one association to RoleLookupRepo
	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleLookupRepo roleLookup;

	//bi-directional many-to-one association to StatusRepo
	@ManyToOne
	@JoinColumn(name="employee_status_id")
	private StatusRepo status;

	//bi-directional many-to-one association to EventDetailRepo
	@OneToMany(mappedBy="employee")
	private List<EventDetailRepo> eventDetails;

	//bi-directional many-to-one association to FeedbackRepo
	@OneToMany(mappedBy="employee")
	private List<FeedbackRepo> feedbacks;

	public EmployeeRepo() {
	}

	public EmployeeRepo(int employeeId, String empEmail) {
		super();
		this.employeeId = employeeId;
		this.empEmail = empEmail;
	}

	public EmployeeRepo(int employeeId, String contact, String empEmail, String empFirstName, String empLastName,
			float evntVolunteerHours, BusinessUnitRepo businessUnit, LocationRepo location, RoleLookupRepo roleLookup,
			StatusRepo status) {
		super();
		this.employeeId = employeeId;
		this.contact = contact;
		this.empEmail = empEmail;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.evntVolunteerHours = evntVolunteerHours;
		this.businessUnit = businessUnit;
		this.location = location;
		this.roleLookup = roleLookup;
		this.status = status;
	}

	public String getEmployeeFullname() {
		return this.empFirstName + " " + this.empLastName;
	}
	
	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Timestamp getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpFirstName() {
		return this.empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return this.empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public float getEvntVolunteerHours() {
		return this.evntVolunteerHours;
	}

	public void setEvntVolunteerHours(float evntVolunteerHours) {
		this.evntVolunteerHours = evntVolunteerHours;
	}

	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BusinessUnitRepo getBusinessUnit() {
		return this.businessUnit;
	}

	public void setBusinessUnit(BusinessUnitRepo businessUnit) {
		this.businessUnit = businessUnit;
	}

	public LocationRepo getLocation() {
		return this.location;
	}

	public void setLocation(LocationRepo location) {
		this.location = location;
	}

	public RoleLookupRepo getRoleLookup() {
		return this.roleLookup;
	}

	public void setRoleLookup(RoleLookupRepo roleLookup) {
		this.roleLookup = roleLookup;
	}

	public StatusRepo getStatus() {
		return this.status;
	}

	public void setStatus(StatusRepo status) {
		this.status = status;
	}

	public List<EventDetailRepo> getEventDetails() {
		return this.eventDetails;
	}

	public void setEventDetails(List<EventDetailRepo> eventDetails) {
		this.eventDetails = eventDetails;
	}

	public EventDetailRepo addEventDetail(EventDetailRepo eventDetail) {
		getEventDetails().add(eventDetail);
		eventDetail.setEmployee(this);

		return eventDetail;
	}

	public EventDetailRepo removeEventDetail(EventDetailRepo eventDetail) {
		getEventDetails().remove(eventDetail);
		eventDetail.setEmployee(null);

		return eventDetail;
	}

	public List<FeedbackRepo> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<FeedbackRepo> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public FeedbackRepo addFeedback(FeedbackRepo feedback) {
		getFeedbacks().add(feedback);
		feedback.setEmployee(this);

		return feedback;
	}

	public FeedbackRepo removeFeedback(FeedbackRepo feedback) {
		getFeedbacks().remove(feedback);
		feedback.setEmployee(null);

		return feedback;
	}

}