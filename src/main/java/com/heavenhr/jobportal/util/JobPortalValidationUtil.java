package com.heavenhr.jobportal.util;

import org.springframework.util.StringUtils;

import com.heavenhr.jobportal.beans.JobApplication;
import com.heavenhr.jobportal.beans.JobOffer;
import com.heavenhr.jobportal.beans.User;

/**
 * 
 * @author AnilKumar
 *
 */
public class JobPortalValidationUtil {

	public static void validateUser(User user) {
		if (StringUtils.isEmpty(user.getEmailId())) {
			ErrorUtil.prepareJobPortalException("Please Give Proper Email Id");
		}
		if (StringUtils.isEmpty(user.getPhoneNumber())) {
			ErrorUtil.prepareJobPortalException("Please Give Proper Phone Number");
		}
		if (StringUtils.isEmpty(user.getName())) {
			ErrorUtil.prepareJobPortalException("Please Give Proper User Name");
		}
	}

	public static void validateJobOffer(JobOffer offer) {
		if (StringUtils.isEmpty(offer.getJobTitle())) {
			ErrorUtil.prepareJobPortalException("Please Give Proper Job Title Name");
		}
		if (StringUtils.isEmpty(offer.getStartDate())) {
			ErrorUtil.prepareJobPortalException("Please Give Proper Start Date");
		}
	}

	public static void validateJobApplication(JobApplication application) {
		if (StringUtils.isEmpty(application.getEmailId())) {
			ErrorUtil.prepareJobPortalException("Please Give Proper Email Id");
		}
		if (StringUtils.isEmpty(application.getJobTitle())) {
			ErrorUtil.prepareJobPortalException("Please Give Proper Job Title Name");
		}
		if (StringUtils.isEmpty(application.getResume())) {
			ErrorUtil.prepareJobPortalException("Please Give Proper User Resume");
		}
	}

}
