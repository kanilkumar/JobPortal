package com.heavenhr.jobportal.exception;
/**
 * 
 * @author AnilKumar
 *
 */
public class JobPortalException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3519390507687587481L;
	private String code;
	private String message;

	public JobPortalException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JobPortalException [code=" + code + ", message=" + message + "]";
	}

}
