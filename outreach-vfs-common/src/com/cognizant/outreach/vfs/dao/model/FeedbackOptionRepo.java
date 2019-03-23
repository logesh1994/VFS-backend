package com.cognizant.outreach.vfs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the feedback_options database table.
 * 
 */
@Entity
@Table(name="feedback_options")
@NamedQuery(name="FeedbackOptionRepo.findAll", query="SELECT f FROM FeedbackOptionRepo f")
public class FeedbackOptionRepo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	//bi-directional many-to-one association to FeedbackRepo
	@OneToMany(mappedBy="feedbackOption")
	private List<FeedbackRepo> feedbacks;

	public FeedbackOptionRepo() {
	}

	public FeedbackOptionRepo(String description) {
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

	public List<FeedbackRepo> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<FeedbackRepo> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public FeedbackRepo addFeedback(FeedbackRepo feedback) {
		getFeedbacks().add(feedback);
		feedback.setFeedbackOption(this);

		return feedback;
	}

	public FeedbackRepo removeFeedback(FeedbackRepo feedback) {
		getFeedbacks().remove(feedback);
		feedback.setFeedbackOption(null);

		return feedback;
	}

}