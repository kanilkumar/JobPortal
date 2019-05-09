package com.heavenhr.jobportal.beans;

import java.text.ParseException;

import com.heavenhr.jobportal.entity.JobApplicationEntity;
import com.heavenhr.jobportal.entity.JobOfferEntity;
import com.heavenhr.jobportal.entity.UserEntity;

/**
 * 
 * 
 * @author AnilKumar
 *
 */

public class JobApplication {

	private String jobTitle;
	private String emailId;
	private String resume;
	private String status;

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static JobApplicationEntity getEntityObject(JobApplication jobApplication, UserEntity user,
			JobOfferEntity jobOffer) throws ParseException {
		JobApplicationEntity entity = new JobApplicationEntity();
		entity.setStatus("APPLIED");
		entity.setUser(user);
		entity.setJobOffer(jobOffer);
		entity.setResume(jobApplication.getResume());
		return entity;
	}

	@Override
	public String toString() {
		return "JobApplication [jobTitle=" + jobTitle + ", emailId=" + emailId + ", resume=" + resume + ", status="
				+ status + "]";
	}

}
