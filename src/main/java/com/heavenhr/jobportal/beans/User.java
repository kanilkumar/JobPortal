package com.heavenhr.jobportal.beans;

import com.heavenhr.jobportal.entity.UserEntity;

/**
 * 
 * @author AnilKumar
 *
 */

public class User {

	private String name;
	private String emailId;
	private String phoneNumber;

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

	public static UserEntity getEntityObject(User user) {
		UserEntity entity = new UserEntity();
		entity.setName(user.getName());
		entity.setEmailId(user.getEmailId());
		entity.setPhoneNumber(user.getPhoneNumber());
		return entity;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + "]";
	}

}
