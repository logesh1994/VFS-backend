package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="status")
@NamedQuery(name="StatusRepo.findAll", query="SELECT s FROM StatusRepo s")
public class StatusRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	//bi-directional many-to-one association to EmployeeRepo
	@OneToMany(mappedBy="status")
	private List<EmployeeRepo> employees;

	//bi-directional many-to-one association to EventDetailRepo
	@OneToMany(mappedBy="status1")
	private List<EventDetailRepo> eventDetails1;

	//bi-directional many-to-one association to EventDetailRepo
	@OneToMany(mappedBy="status2")
	private List<EventDetailRepo> eventDetails2;

	public StatusRepo() {
	}

	public StatusRepo(String description) {
		super();
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<EmployeeRepo> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeRepo> employees) {
		this.employees = employees;
	}

	public EmployeeRepo addEmployee(EmployeeRepo employee) {
		getEmployees().add(employee);
		employee.setStatus(this);

		return employee;
	}

	public EmployeeRepo removeEmployee(EmployeeRepo employee) {
		getEmployees().remove(employee);
		employee.setStatus(null);

		return employee;
	}

	public List<EventDetailRepo> getEventDetails1() {
		return this.eventDetails1;
	}

	public void setEventDetails1(List<EventDetailRepo> eventDetails1) {
		this.eventDetails1 = eventDetails1;
	}

	public EventDetailRepo addEventDetails1(EventDetailRepo eventDetails1) {
		getEventDetails1().add(eventDetails1);
		eventDetails1.setStatus1(this);

		return eventDetails1;
	}

	public EventDetailRepo removeEventDetails1(EventDetailRepo eventDetails1) {
		getEventDetails1().remove(eventDetails1);
		eventDetails1.setStatus1(null);

		return eventDetails1;
	}

	public List<EventDetailRepo> getEventDetails2() {
		return this.eventDetails2;
	}

	public void setEventDetails2(List<EventDetailRepo> eventDetails2) {
		this.eventDetails2 = eventDetails2;
	}

	public EventDetailRepo addEventDetails2(EventDetailRepo eventDetails2) {
		getEventDetails2().add(eventDetails2);
		eventDetails2.setStatus2(this);

		return eventDetails2;
	}

	public EventDetailRepo removeEventDetails2(EventDetailRepo eventDetails2) {
		getEventDetails2().remove(eventDetails2);
		eventDetails2.setStatus2(null);

		return eventDetails2;
	}

}