package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role_lookup database table.
 * 
 */
@Entity
@Table(name="role_lookup")
@NamedQuery(name="RoleLookupRepo.findAll", query="SELECT r FROM RoleLookupRepo r")
public class RoleLookupRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	//bi-directional many-to-one association to EmployeeRepo
	@OneToMany(mappedBy="roleLookup")
	private List<EmployeeRepo> employees;

	public RoleLookupRepo() {
	}

	public RoleLookupRepo(String description) {
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
		employee.setRoleLookup(this);

		return employee;
	}

	public EmployeeRepo removeEmployee(EmployeeRepo employee) {
		getEmployees().remove(employee);
		employee.setRoleLookup(null);

		return employee;
	}

}