package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@Table(name="feedback")
@NamedQuery(name="FeedbackRepo.findAll", query="SELECT f FROM FeedbackRepo f")
public class FeedbackRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="admin_feedback")
	private String adminFeedback;

	@Column(name="create_timestamp")
	private Timestamp createTimestamp;

	@Column(name="improve_feedback")
	private String improveFeedback;

	@Column(name="like_feedback")
	private String likeFeedback;

	//bi-directional many-to-one association to EmployeeRepo
	@ManyToOne
	@JoinColumn(name="update_id")
	private EmployeeRepo employee;

	//bi-directional many-to-one association to EventDetailRepo
	@ManyToOne
	@JoinColumn(name="event_detail_id")
	private EventDetailRepo eventDetail;

	//bi-directional many-to-one association to FeedbackOptionRepo
	@ManyToOne
	@JoinColumn(name="feedback_option_id")
	private FeedbackOptionRepo feedbackOption;

	//bi-directional many-to-one association to RatingRepo
	@ManyToOne
	@JoinColumn(name="rating")
	private RatingRepo ratingBean;

	public FeedbackRepo() {
	}

	public FeedbackRepo(String improveFeedback, String likeFeedback, EmployeeRepo employee, EventDetailRepo eventDetail,
			FeedbackOptionRepo feedbackOption, RatingRepo ratingBean) {
		super();
		this.improveFeedback = improveFeedback;
		this.likeFeedback = likeFeedback;
		this.employee = employee;
		this.eventDetail = eventDetail;
		this.feedbackOption = feedbackOption;
		this.ratingBean = ratingBean;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminFeedback() {
		return this.adminFeedback;
	}

	public void setAdminFeedback(String adminFeedback) {
		this.adminFeedback = adminFeedback;
	}

	public Timestamp getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getImproveFeedback() {
		return this.improveFeedback;
	}

	public void setImproveFeedback(String improveFeedback) {
		this.improveFeedback = improveFeedback;
	}

	public String getLikeFeedback() {
		return this.likeFeedback;
	}

	public void setLikeFeedback(String likeFeedback) {
		this.likeFeedback = likeFeedback;
	}

	public EmployeeRepo getEmployee() {
		return this.employee;
	}

	public void setEmployee(EmployeeRepo employee) {
		this.employee = employee;
	}

	public EventDetailRepo getEventDetail() {
		return this.eventDetail;
	}

	public void setEventDetail(EventDetailRepo eventDetail) {
		this.eventDetail = eventDetail;
	}

	public FeedbackOptionRepo getFeedbackOption() {
		return this.feedbackOption;
	}

	public void setFeedbackOption(FeedbackOptionRepo feedbackOption) {
		this.feedbackOption = feedbackOption;
	}

	public RatingRepo getRatingBean() {
		return this.ratingBean;
	}

	public void setRatingBean(RatingRepo ratingBean) {
		this.ratingBean = ratingBean;
	}

}