package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@Table(name="location")
@NamedQuery(name="LocationRepo.findAll", query="SELECT l FROM LocationRepo l")
public class LocationRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String city;

	private String country;

	private String state;

	//bi-directional many-to-one association to BusinessUnitRepo
	@OneToMany(mappedBy="location")
	private List<BusinessUnitRepo> businessUnits;

	//bi-directional many-to-one association to EmployeeRepo
	@OneToMany(mappedBy="location")
	private List<EmployeeRepo> employees;

	//bi-directional many-to-one association to EventCouncilRepo
	@OneToMany(mappedBy="location")
	private List<EventCouncilRepo> eventCouncils;

	//bi-directional many-to-one association to EventRepo
	@OneToMany(mappedBy="location")
	private List<EventRepo> events;

	public LocationRepo() {
	}

	public LocationRepo(String city) {
		super();
		this.city = city;
	}

	public LocationRepo(String city, String country, String state) {
		super();
		this.city = city;
		this.country = country;
		this.state = state;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<BusinessUnitRepo> getBusinessUnits() {
		return this.businessUnits;
	}

	public void setBusinessUnits(List<BusinessUnitRepo> businessUnits) {
		this.businessUnits = businessUnits;
	}

	public BusinessUnitRepo addBusinessUnit(BusinessUnitRepo businessUnit) {
		getBusinessUnits().add(businessUnit);
		businessUnit.setLocation(this);

		return businessUnit;
	}

	public BusinessUnitRepo removeBusinessUnit(BusinessUnitRepo businessUnit) {
		getBusinessUnits().remove(businessUnit);
		businessUnit.setLocation(null);

		return businessUnit;
	}

	public List<EmployeeRepo> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeRepo> employees) {
		this.employees = employees;
	}

	public EmployeeRepo addEmployee(EmployeeRepo employee) {
		getEmployees().add(employee);
		employee.setLocation(this);

		return employee;
	}

	public EmployeeRepo removeEmployee(EmployeeRepo employee) {
		getEmployees().remove(employee);
		employee.setLocation(null);

		return employee;
	}

	public List<EventCouncilRepo> getEventCouncils() {
		return this.eventCouncils;
	}

	public void setEventCouncils(List<EventCouncilRepo> eventCouncils) {
		this.eventCouncils = eventCouncils;
	}

	public EventCouncilRepo addEventCouncil(EventCouncilRepo eventCouncil) {
		getEventCouncils().add(eventCouncil);
		eventCouncil.setLocation(this);

		return eventCouncil;
	}

	public EventCouncilRepo removeEventCouncil(EventCouncilRepo eventCouncil) {
		getEventCouncils().remove(eventCouncil);
		eventCouncil.setLocation(null);

		return eventCouncil;
	}

	public List<EventRepo> getEvents() {
		return this.events;
	}

	public void setEvents(List<EventRepo> events) {
		this.events = events;
	}

	public EventRepo addEvent(EventRepo event) {
		getEvents().add(event);
		event.setLocation(this);

		return event;
	}

	public EventRepo removeEvent(EventRepo event) {
		getEvents().remove(event);
		event.setLocation(null);

		return event;
	}

}