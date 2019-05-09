package com.heavenhr.jobportal.util;

import com.heavenhr.jobportal.exception.JobPortalException;

public class ErrorUtil {

	public static void prepareJobPortalException(String message) {
		throw new JobPortalException("500", message);
	}

}
