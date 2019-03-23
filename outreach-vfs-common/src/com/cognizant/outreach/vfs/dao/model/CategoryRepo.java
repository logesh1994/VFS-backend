package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="CategoryRepo.findAll", query="SELECT c FROM CategoryRepo c")
public class CategoryRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	//bi-directional many-to-one association to EventRepo
	@OneToMany(mappedBy="category")
	private List<EventRepo> events;

	public CategoryRepo() {
	}

	public CategoryRepo(String description) {
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
		event.setCategory(this);

		return event;
	}

	public EventRepo removeEvent(EventRepo event) {
		getEvents().remove(event);
		event.setCategory(null);

		return event;
	}

}