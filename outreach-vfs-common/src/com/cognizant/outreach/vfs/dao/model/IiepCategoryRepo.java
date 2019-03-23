package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the iiep_category database table.
 * 
 */
@Entity
@Table(name="iiep_category")
@NamedQuery(name="IiepCategoryRepo.findAll", query="SELECT i FROM IiepCategoryRepo i")
public class IiepCategoryRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	//bi-directional many-to-one association to EventRepo
	@OneToMany(mappedBy="iiepCategory")
	private List<EventRepo> events;

	public IiepCategoryRepo() {
	}

	public IiepCategoryRepo(String description) {
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

	public List<EventRepo> getEvents() {
		return this.events;
	}

	public void setEvents(List<EventRepo> events) {
		this.events = events;
	}

	public EventRepo addEvent(EventRepo event) {
		getEvents().add(event);
		event.setIiepCategory(this);

		return event;
	}

	public EventRepo removeEvent(EventRepo event) {
		getEvents().remove(event);
		event.setIiepCategory(null);

		return event;
	}

}