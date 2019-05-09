package com.heavenhr.jobportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 
 * @author AnilKumar
 *
 */
@Entity
@Table(name = "JOB_APPLICATIONS", uniqueConstraints = @UniqueConstraint(columnNames = { "USER_ID", "JOB_OFFER_ID" }))
public class JobApplicationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserEntity user;
	@Column(name = "RESUME")
	private String resume;
	@ManyToOne
	@JoinColumn(name = "JOB_OFFER_ID")
	private JobOfferEntity jobOffer;
	@Column(name = "STATUS")
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public JobOfferEntity getJobOffer() {
		return jobOffer;
	}

	public void setJobOffer(JobOfferEntity jobOffer) {
		this.jobOffer = jobOffer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
