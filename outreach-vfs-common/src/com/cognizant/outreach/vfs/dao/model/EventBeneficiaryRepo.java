package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the event_beneficiary database table.
 * 
 */
@Entity
@Table(name="event_beneficiary")
@NamedQuery(name="EventBeneficiaryRepo.findAll", query="SELECT e FROM EventBeneficiaryRepo e")
public class EventBeneficiaryRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	//bi-directional many-to-one association to EventRepo
	@OneToMany(mappedBy="eventBeneficiary")
	private List<EventRepo> events;

	public EventBeneficiaryRepo() {
	}

	public EventBeneficiaryRepo(String description) {
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
		event.setEventBeneficiary(this);

		return event;
	}

	public EventRepo removeEvent(EventRepo event) {
		getEvents().remove(event);
		event.setEventBeneficiary(null);

		return event;
	}

}