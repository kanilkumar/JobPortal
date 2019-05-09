package com.heavenhr.jobportal.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.heavenhr.jobportal.entity.JobOfferEntity;

/**
 * 
 * @author AnilKumar
 *
 */
public class JobOffer {

	private String jobTitle;
	private String startDate;

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public static JobOfferEntity getEntityObject(JobOffer jobOffer) throws ParseException {
		JobOfferEntity entity = new JobOfferEntity();
		entity.setJobTitle(jobOffer.getJobTitle());
		entity.setStartDate(
				new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy").parse(jobOffer.getStartDate()).getTime()));
		return entity;
	}

	public static JobOffer getObject(JobOfferEntity entity) throws ParseException {
		JobOffer offer = new JobOffer();
		offer.setJobTitle(entity.getJobTitle());
		offer.setStartDate(new SimpleDateFormat("dd-MM-yyyy").format(entity.getStartDate()));
		return offer;
	}

	@Override
	public String toString() {
		return "JobOffer [jobTitle=" + jobTitle + ", startDate=" + startDate + "]";
	}

}
