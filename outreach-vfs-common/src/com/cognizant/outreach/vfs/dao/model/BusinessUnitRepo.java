package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the business_unit database table.
 * 
 */
@Entity
@Table(name="business_unit")
@NamedQuery(name="BusinessUnitRepo.findAll", query="SELECT b FROM BusinessUnitRepo b")
public class BusinessUnitRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="buss_unit_name")
	private String bussUnitName;

	//bi-directional many-to-one association to LocationRepo
	@ManyToOne
	private LocationRepo location;

	//bi-directional many-to-one association to EmployeeRepo
	@OneToMany(mappedBy="businessUnit")
	private List<EmployeeRepo> employees;

	public BusinessUnitRepo() {
	}

	public BusinessUnitRepo(String bussUnitName, LocationRepo location) {
		super();
		this.bussUnitName = bussUnitName;
		this.location = location;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBussUnitName() {
		return this.bussUnitName;
	}

	public void setBussUnitName(String bussUnitName) {
		this.bussUnitName = bussUnitName;
	}

	public LocationRepo getLocation() {
		return this.location;
	}

	public void setLocation(LocationRepo location) {
		this.location = location;
	}

	public List<EmployeeRepo> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeRepo> employees) {
		this.employees = employees;
	}

	public EmployeeRepo addEmployee(EmployeeRepo employee) {
		getEmployees().add(employee);
		employee.setBusinessUnit(this);

		return employee;
	}

	public EmployeeRepo removeEmployee(EmployeeRepo employee) {
		getEmployees().remove(employee);
		employee.setBusinessUnit(null);

		return employee;
	}

}