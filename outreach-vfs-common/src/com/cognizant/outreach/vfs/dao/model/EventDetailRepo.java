package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the event_details database table.
 * 
 */
@Entity
@Table(name="event_details")
@NamedQuery(name="EventDetailRepo.findAll", query="SELECT e FROM EventDetailRepo e")
public class EventDetailRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="created_by_id")
	private int createdById;

	@Column(name="created_timestamp")
	private Timestamp createdTimestamp;

	@Column(name="travel_hrs")
	private float travelHrs;

	@Column(name="volunteer_hrs")
	private float volunteerHrs;

	//bi-directional many-to-one association to EmployeeRepo
	@ManyToOne
	@JoinColumn(name="employee_id")
	private EmployeeRepo employee;

	//bi-directional many-to-one association to EventRepo
	@ManyToOne
	@JoinColumn(name="evnt_id")
	private EventRepo event;

	//bi-directional many-to-one association to StatusRepo
	@ManyToOne
	@JoinColumn(name="participation_status_id")
	private StatusRepo status1;

	//bi-directional many-to-one association to StatusRepo
	@ManyToOne
	@JoinColumn(name="feedback_status_id")
	private StatusRepo status2;

	//bi-directional many-to-one association to FeedbackRepo
	@OneToMany(mappedBy="eventDetail")
	private List<FeedbackRepo> feedbacks;

	public EventDetailRepo() {
	}

	public EventDetailRepo(int createdById, float travelHrs, float volunteerHrs, EmployeeRepo employee,
			EventRepo event, StatusRepo status1, StatusRepo status2) {
		super();
		this.createdById = createdById;
		this.travelHrs = travelHrs;
		this.volunteerHrs = volunteerHrs;
		this.employee = employee;
		this.event = event;
		this.status1 = status1;
		this.status2 = status2;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedById() {
		return this.createdById;
	}

	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}

	public Timestamp getCreatedTimestamp() {
		return this.createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public float getTravelHrs() {
		return this.travelHrs;
	}

	public void setTravelHrs(float travelHrs) {
		this.travelHrs = travelHrs;
	}

	public float getVolunteerHrs() {
		return this.volunteerHrs;
	}

	public void setVolunteerHrs(float volunteerHrs) {
		this.volunteerHrs = volunteerHrs;
	}

	public EmployeeRepo getEmployee() {
		return this.employee;
	}

	public void setEmployee(EmployeeRepo employee) {
		this.employee = employee;
	}

	public EventRepo getEvent() {
		return this.event;
	}

	public void setEvent(EventRepo event) {
		this.event = event;
	}

	public StatusRepo getStatus1() {
		return this.status1;
	}

	public void setStatus1(StatusRepo status1) {
		this.status1 = status1;
	}

	public StatusRepo getStatus2() {
		return this.status2;
	}

	public void setStatus2(StatusRepo status2) {
		this.status2 = status2;
	}

	public List<FeedbackRepo> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<FeedbackRepo> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public FeedbackRepo addFeedback(FeedbackRepo feedback) {
		getFeedbacks().add(feedback);
		feedback.setEventDetail(this);

		return feedback;
	}

	public FeedbackRepo removeFeedback(FeedbackRepo feedback) {
		getFeedbacks().remove(feedback);
		feedback.setEventDetail(null);

		return feedback;
	}

}