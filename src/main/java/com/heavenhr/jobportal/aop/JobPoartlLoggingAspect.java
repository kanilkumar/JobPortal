package com.heavenhr.jobportal.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.heavenhr.jobportal.constants.JobPortalConstants;

/**
 * 
 * @author AnilKumar
 *
 */
@Aspect
@Component
public class JobPoartlLoggingAspect {

	private final Logger LOG = LoggerFactory.getLogger(JobPoartlLoggingAspect.class);

	@Before("execution(* com.heavenhr.jobportal.controller.JobPortalController.*(..))")
	public void methodStartLogginInfoAspect(JoinPoint jp) {
		LOG.info(JobPortalConstants.METHOD_START,
				jp.getSignature().getDeclaringTypeName() + ":" + jp.getSignature().getName(),
				Arrays.asList(jp.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.heavenhr.jobportal.controller.JobPortalController.*(..))", returning = "returnValue")
	public void methodEndLogginInfoAspect(JoinPoint jp, Object returnValue) {
		LOG.info(JobPortalConstants.METHOD_END, jp.getSignature().getDeclaringTypeName() + ":"
				+ jp.getSignature().getName() + JobPortalConstants.RETURN_VALUE + returnValue);
	}

	@Before("execution(* com.heavenhr.jobportal.service.JobPortalServiceImpl.*(..))")
	public void serviceMethodStartLogginInfoAspect(JoinPoint jp) {
		LOG.info(JobPortalConstants.METHOD_START,
				jp.getSignature().getDeclaringTypeName() + ":" + jp.getSignature().getName(),
				Arrays.asList(jp.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.heavenhr.jobportal.service.JobPortalServiceImpl.*(..))", returning = "returnValue")
	public void serviceMethodEndLogginInfoAspect(JoinPoint jp, Object returnValue) {
		LOG.info(JobPortalConstants.METHOD_END, jp.getSignature().getDeclaringTypeName() + ":"
				+ jp.getSignature().getName() + JobPortalConstants.RETURN_VALUE + returnValue);
	}
}
