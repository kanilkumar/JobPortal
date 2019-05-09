package com.heavenhr.jobportal.entity;
/**
 * 
 * @author AnilKumar
 *
 */

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL_ID", unique = true)
	private String emailId;
	@Column(name = "PHONE_NUMBER", unique = true)
	private String phoneNumber;
	@OneToMany(mappedBy = "user")
	private List<JobApplicationEntity> applications;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<JobApplicationEntity> getApplications() {
		return applications;
	}

	public void setApplications(List<JobApplicationEntity> applications) {
		this.applications = applications;
	}

}
