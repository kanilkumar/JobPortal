package com.heavenhr.jobportal.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.heavenhr.jobportal.beans.JobApplication;
import com.heavenhr.jobportal.beans.JobOffer;
import com.heavenhr.jobportal.beans.User;
import com.heavenhr.jobportal.dao.JobPortalDao;
import com.heavenhr.jobportal.entity.JobApplicationEntity;
import com.heavenhr.jobportal.entity.JobOfferEntity;
import com.heavenhr.jobportal.entity.UserEntity;

/**
 * 
 * @author AnilKumar
 *
 */
@Service
public class JobPortalServiceImpl implements JobPortalService {

	@Autowired
	JobPortalDao jobPortalDao;

	@Override
	public void createJobOffer(JobOffer jobOffer) throws ParseException {

		jobPortalDao.createJobOffer(JobOffer.getEntityObject(jobOffer));
	}

	@Override
	public List<JobOffer> getJobOffers(String jobTitle) throws ParseException {
		List<JobOffer> offersList = new ArrayList<JobOffer>();
		if (StringUtils.isEmpty(jobTitle)) {
			List<JobOfferEntity> jobOfferEntityList = jobPortalDao.getJobOffers();
			for (JobOfferEntity entity : jobOfferEntityList) {
				offersList.add(JobOffer.getObject(entity));
			}
		} else {
			JobOfferEntity jobOffer = jobPortalDao.getJobOfferByJobTitle(jobTitle);
			offersList.add(JobOffer.getObject(jobOffer));
		}
		return offersList;
	}

	@Override
	public void applyJobOffer(JobApplication jobApplication) throws ParseException {
		UserEntity user = jobPortalDao.getUser(jobApplication.getEmailId());
		JobOfferEntity jobOffer = jobPortalDao.getJobOfferByJobTitle(jobApplication.getJobTitle());
		jobPortalDao.applyJobOffer(JobApplication.getEntityObject(jobApplication, user, jobOffer));
	}

	@Override
	public void createUser(User user) {
		jobPortalDao.createUser(User.getEntityObject(user));
	}

	@Override
	public List<JobApplication> getJobApplications(String jobTitle) {
		List<JobApplication> applicationList = new ArrayList<>();
		JobOfferEntity jobOffer = jobPortalDao.getJobOfferByJobTitle(jobTitle);
		List<JobApplicationEntity> applications = jobPortalDao.getApplications(jobOffer.getId());
		for (JobApplicationEntity entity : applications) {
			JobApplication application = new JobApplication();
			application.setStatus(entity.getStatus());
			application.setEmailId(entity.getUser().getEmailId());
			application.setJobTitle(entity.getJobOffer().getJobTitle());
			application.setResume(entity.getResume());
			applicationList.add(application);
		}
		return applicationList;
	}

	@Override
	public void updateApplicationStatus(JobApplication jobApplication) {
		UserEntity user = jobPortalDao.getUser(jobApplication.getEmailId());
		JobOfferEntity jobOffer = jobPortalDao.getJobOfferByJobTitle(jobApplication.getJobTitle());
		JobApplicationEntity jobApplicationEntity = jobPortalDao.getApplicationByUserAndJobTitle(jobOffer.getId(),
				user.getId());
		jobApplicationEntity.setStatus(jobApplication.getStatus());
		jobPortalDao.updateApplicationStatus(jobApplicationEntity);
	}

	@Override
	public List<JobApplication> trackApplicationsStatus(String emailId) {
		List<JobApplication> applicationList = new ArrayList<>();
		UserEntity user = jobPortalDao.getUser(emailId);
		List<JobApplicationEntity> applications = jobPortalDao.getApplicationsByUser(user.getId());
		for (JobApplicationEntity entity : applications) {
			JobApplication application = new JobApplication();
			application.setStatus(entity.getStatus());
			application.setEmailId(entity.getUser().getEmailId());
			application.setJobTitle(entity.getJobOffer().getJobTitle());
			application.setResume(entity.getResume());
			applicationList.add(application);
		}
		return applicationList;
	}

}
