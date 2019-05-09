package com.heavenhr.jobportal.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heavenhr.jobportal.beans.JobApplication;
import com.heavenhr.jobportal.beans.JobOffer;
import com.heavenhr.jobportal.beans.User;
import com.heavenhr.jobportal.service.JobPortalService;
import com.heavenhr.jobportal.util.JobPortalValidationUtil;

/**
 * 
 * @author AnilKumar
 *
 */
@RestController
@RequestMapping(value = "/api/germany/v1")
public class JobPortalController {

	@Autowired
	JobPortalService jobPortalServie;

	@RequestMapping(value = "/create/joboffer", method = RequestMethod.POST)
	public void createJobOffer(@RequestBody JobOffer jobOffer) throws ParseException {
		JobPortalValidationUtil.validateJobOffer(jobOffer);
		jobPortalServie.createJobOffer(jobOffer);
	}

	@RequestMapping(value = "/get/joboffers", method = RequestMethod.GET)
	public List<JobOffer> getJobOffers(@RequestParam("jobTitle") String jobTitle) throws ParseException {
		return jobPortalServie.getJobOffers(jobTitle);
	}

	@RequestMapping(value = "/apply/joboffer", method = RequestMethod.POST)
	public void applyJobOffer(@RequestBody JobApplication jobApplication) throws ParseException {
		JobPortalValidationUtil.validateJobApplication(jobApplication);
		jobPortalServie.applyJobOffer(jobApplication);
	}

	@RequestMapping(value = "/get/applications", method = RequestMethod.GET)
	public List<JobApplication> getJobApplications(@RequestParam("jobTitle") String jobTitle) {
		return jobPortalServie.getJobApplications(jobTitle);
	}

	@RequestMapping(value = "/staus/update", method = RequestMethod.PUT)
	public void updateApplicationStatus(@RequestBody JobApplication jobApplication) {
		jobPortalServie.updateApplicationStatus(jobApplication);
	}

	@RequestMapping(value = "/staus/track", method = RequestMethod.GET)
	public List<JobApplication> trackApplicationsStatus(@RequestParam("emailId") String emailId) {
		return jobPortalServie.trackApplicationsStatus(emailId);
	}

	@RequestMapping(value = "/create/user", method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		JobPortalValidationUtil.validateUser(user);
		jobPortalServie.createUser(user);
	}

}
