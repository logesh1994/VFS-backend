package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the event_council database table.
 * 
 */
@Entity
@Table(name="event_council")
@NamedQuery(name="EventCouncilRepo.findAll", query="SELECT e FROM EventCouncilRepo e")
public class EventCouncilRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="council_name")
	private String councilName;

	//bi-directional many-to-one association to EventRepo
	@OneToMany(mappedBy="eventCouncil")
	private List<EventRepo> events;

	//bi-directional many-to-one association to LocationRepo
	@ManyToOne
	private LocationRepo location;

	public EventCouncilRepo() {
	}

	public EventCouncilRepo(String councilName, LocationRepo location) {
		super();
		this.councilName = councilName;
		this.location = location;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCouncilName() {
		return this.councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	public List<EventRepo> getEvents() {
		return this.events;
	}

	public void setEvents(List<EventRepo> events) {
		this.events = events;
	}

	public EventRepo addEvent(EventRepo event) {
		getEvents().add(event);
		event.setEventCouncil(this);

		return event;
	}

	public EventRepo removeEvent(EventRepo event) {
		getEvents().remove(event);
		event.setEventCouncil(null);

		return event;
	}

	public LocationRepo getLocation() {
		return this.location;
	}

	public void setLocation(LocationRepo location) {
		this.location = location;
	}

}