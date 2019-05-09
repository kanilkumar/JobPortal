package com.heavenhr.jobportal.test;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heavenhr.jobportal.app.JobPortalApplication;
import com.heavenhr.jobportal.beans.JobOffer;
import com.heavenhr.jobportal.beans.User;
import com.heavenhr.jobportal.service.JobPortalService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { JobPortalApplication.class })
public class JobPortalTestApp {

	@Autowired
	JobPortalService jobPortalService;

	@Test
	public void testCreateJobOffer() throws ParseException {
		JobOffer jobOffer = new JobOffer();
		jobOffer.setJobTitle("Test Title");
		jobOffer.setStartDate("08-05-2019");
		jobPortalService.createJobOffer(jobOffer);
	}

	@Test
	public void testCreateUser() throws ParseException {
		User user = new User();
		user.setEmailId("anilkumar@gmail.com");
		user.setName("Anil");
		user.setPhoneNumber("9581525106");
		jobPortalService.createUser(user);
	}


}
