package com.heavenhr.jobportal.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 
 * @author AnilKumar
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "JOB_OFFER", uniqueConstraints = @UniqueConstraint(columnNames = { "JOB_TITLE" }))
public class JobOfferEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "JOB_TITLE")
	private String jobTitle;

	@Column(name = "START_DATE")
	private Date startDate;

	@OneToMany//(mappedBy = "jobOffer")
	@JoinColumn(name="JOB_OFFER_ID")
	private List<JobApplicationEntity> applications;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<JobApplicationEntity> getApplications() {
		return applications;
	}

	public void setApplications(List<JobApplicationEntity> applications) {
		this.applications = applications;
	}

}
