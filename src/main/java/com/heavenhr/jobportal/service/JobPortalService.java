package com.heavenhr.jobportal.service;

import java.text.ParseException;
import java.util.List;

import com.heavenhr.jobportal.beans.JobApplication;
import com.heavenhr.jobportal.beans.JobOffer;
import com.heavenhr.jobportal.beans.User;

/**
 * 
 * @author AnilKumar
 *
 */
public interface JobPortalService {

	void createJobOffer(JobOffer jobOffer) throws ParseException;

	List<JobOffer> getJobOffers(String isAll) throws ParseException;

	void applyJobOffer(JobApplication jobApplication) throws ParseException;

	void createUser(User user);

	List<JobApplication> getJobApplications(String jobTitle);

	void updateApplicationStatus(JobApplication jobApplication);

	List<JobApplication> trackApplicationsStatus(String emailId);

}
