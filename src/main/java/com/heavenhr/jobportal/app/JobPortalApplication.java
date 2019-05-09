package com.heavenhr.jobportal.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author AnilKumar
 *
 */
@SpringBootApplication
@ComponentScan("com.heavenhr.jobportal")
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class JobPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobPortalApplication.class, args);
	}
}
