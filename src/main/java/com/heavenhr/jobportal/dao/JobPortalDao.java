package com.heavenhr.jobportal.dao;

import java.text.ParseException;
import java.util.List;

import com.heavenhr.jobportal.entity.JobApplicationEntity;
import com.heavenhr.jobportal.entity.JobOfferEntity;
import com.heavenhr.jobportal.entity.UserEntity;

/**
 * 
 * @author AnilKumar
 *
 */
public interface JobPortalDao {

	void createJobOffer(JobOfferEntity jobOfferEntity) throws ParseException;

	List<JobOfferEntity> getJobOffers() throws ParseException;

	void applyJobOffer(JobApplicationEntity jobApplicationEntity);

	void createUser(UserEntity userEntity);

	UserEntity getUser(String emailId);

	JobOfferEntity getJobOfferByJobTitle(String jobTitle);

	List<JobApplicationEntity> getApplications(long jobTitle);

	JobApplicationEntity getApplicationByUserAndJobTitle(long jobOfferId, long userId);

	void updateApplicationStatus(JobApplicationEntity jobApplication);

	List<JobApplicationEntity> getApplicationsByUser(long userId);
}
