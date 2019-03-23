package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@Table(name="event")
@NamedQuery(name="EventRepo.findAll", query="SELECT e FROM EventRepo e")
public class EventRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="created_by_id")
	private int createdById;

	@Column(name="created_timestamp")
	private Timestamp createdTimestamp;

	@Column(name="`event_poc's`")
	private String eventPoc_s;

	@Temporal(TemporalType.DATE)
	@Column(name="evnt_date")
	private Date evntDate;

	@Column(name="evnt_description")
	private String evntDescription;

	@Column(name="evnt_name")
	private String evntName;

	@Column(name="lives_impacted")
	private int livesImpacted;

	private String month;

	@Column(name="overall_volunteer_hrs")
	private float overallVolunteerHrs;

	@Column(name="total_travel_hrs")
	private float totalTravelHrs;

	@Column(name="total_volunteer_hrs")
	private float totalVolunteerHrs;

	@Column(name="total_volunteers")
	private int totalVolunteers;

	@Column(name="venue_address")
	private String venueAddress;

	//bi-directional many-to-one association to EventCouncilRepo
	@ManyToOne
	@JoinColumn(name="event_council_id")
	private EventCouncilRepo eventCouncil;

	//bi-directional many-to-one association to IiepCategoryRepo
	@ManyToOne
	@JoinColumn(name="iiep_category_id")
	private IiepCategoryRepo iiepCategory;

	//bi-directional many-to-one association to EventDetailRepo
	@OneToMany(mappedBy="event")
	private List<EventDetailRepo> eventDetails;

	//bi-directional many-to-one association to LocationRepo
	@ManyToOne
	@JoinColumn(name="evnt_base_location_id")
	private LocationRepo location;

	//bi-directional many-to-one association to EventBeneficiary
	@ManyToOne
	@JoinColumn(name="evnt_benef_id")
	private EventBeneficiaryRepo eventBeneficiary;

	//bi-directional many-to-one association to Project
	@ManyToOne
	private ProjectRepo project;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private CategoryRepo category;

	public EventRepo() {
	}

	public EventRepo(String id, int createdById, String eventPoc_s, Date evntDate, String evntDescription,
			String evntName, int livesImpacted, String month, float overallVolunteerHrs, float totalTravelHrs,
			float totalVolunteerHrs, int totalVolunteers, String venueAddress, EventCouncilRepo eventCouncil,
			IiepCategoryRepo iiepCategory, LocationRepo location, EventBeneficiaryRepo eventBeneficiary, ProjectRepo project,
			CategoryRepo category) {
		super();
		this.id = id;
		this.createdById = createdById;
		this.eventPoc_s = eventPoc_s;
		this.evntDate = evntDate;
		this.evntDescription = evntDescription;
		this.evntName = evntName;
		this.livesImpacted = livesImpacted;
		this.month = month;
		this.overallVolunteerHrs = overallVolunteerHrs;
		this.totalTravelHrs = totalTravelHrs;
		this.totalVolunteerHrs = totalVolunteerHrs;
		this.totalVolunteers = totalVolunteers;
		this.venueAddress = venueAddress;
		this.eventCouncil = eventCouncil;
		this.iiepCategory = iiepCategory;
		this.location = location;
		this.eventBeneficiary = eventBeneficiary;
		this.project = project;
		this.category = category;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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

	public String getEventPoc_s() {
		return this.eventPoc_s;
	}

	public void setEventPoc_s(String eventPoc_s) {
		this.eventPoc_s = eventPoc_s;
	}

	public Date getEvntDate() {
		return this.evntDate;
	}

	public void setEvntDate(Date evntDate) {
		this.evntDate = evntDate;
	}

	public String getEvntDescription() {
		return this.evntDescription;
	}

	public void setEvntDescription(String evntDescription) {
		this.evntDescription = evntDescription;
	}

	public String getEvntName() {
		return this.evntName;
	}

	public void setEvntName(String evntName) {
		this.evntName = evntName;
	}

	public int getLivesImpacted() {
		return this.livesImpacted;
	}

	public void setLivesImpacted(int livesImpacted) {
		this.livesImpacted = livesImpacted;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public float getOverallVolunteerHrs() {
		return this.overallVolunteerHrs;
	}

	public void setOverallVolunteerHrs(float overallVolunteerHrs) {
		this.overallVolunteerHrs = overallVolunteerHrs;
	}

	public float getTotalTravelHrs() {
		return this.totalTravelHrs;
	}

	public void setTotalTravelHrs(float totalTravelHrs) {
		this.totalTravelHrs = totalTravelHrs;
	}

	public float getTotalVolunteerHrs() {
		return this.totalVolunteerHrs;
	}

	public void setTotalVolunteerHrs(float totalVolunteerHrs) {
		this.totalVolunteerHrs = totalVolunteerHrs;
	}

	public int getTotalVolunteers() {
		return this.totalVolunteers;
	}

	public void setTotalVolunteers(int totalVolunteers) {
		this.totalVolunteers = totalVolunteers;
	}

	public String getVenueAddress() {
		return this.venueAddress;
	}

	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}

	public EventCouncilRepo getEventCouncil() {
		return this.eventCouncil;
	}

	public void setEventCouncil(EventCouncilRepo eventCouncil) {
		this.eventCouncil = eventCouncil;
	}

	public IiepCategoryRepo getIiepCategory() {
		return this.iiepCategory;
	}

	public void setIiepCategory(IiepCategoryRepo iiepCategory) {
		this.iiepCategory = iiepCategory;
	}

	public List<EventDetailRepo> getEventDetails() {
		return this.eventDetails;
	}

	public void setEventDetails(List<EventDetailRepo> eventDetails) {
		this.eventDetails = eventDetails;
	}

	public EventDetailRepo addEventDetail(EventDetailRepo eventDetail) {
		getEventDetails().add(eventDetail);
		eventDetail.setEvent(this);

		return eventDetail;
	}

	public EventDetailRepo removeEventDetail(EventDetailRepo eventDetail) {
		getEventDetails().remove(eventDetail);
		eventDetail.setEvent(null);

		return eventDetail;
	}

	public LocationRepo getLocation() {
		return this.location;
	}

	public void setLocation(LocationRepo location) {
		this.location = location;
	}

	public EventBeneficiaryRepo getEventBeneficiary() {
		return this.eventBeneficiary;
	}

	public void setEventBeneficiary(EventBeneficiaryRepo eventBeneficiary) {
		this.eventBeneficiary = eventBeneficiary;
	}

	public ProjectRepo getProject() {
		return this.project;
	}

	public void setProject(ProjectRepo project) {
		this.project = project;
	}

	public CategoryRepo getCategory() {
		return this.category;
	}

	public void setCategory(CategoryRepo category) {
		this.category = category;
	}

}