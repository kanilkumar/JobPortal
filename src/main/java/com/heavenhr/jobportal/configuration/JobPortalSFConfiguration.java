package com.heavenhr.jobportal.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
/**
 * 
 * @author AnilKumar
 *
 */
@Configuration
public class JobPortalSFConfiguration {

	@Bean
	public SessionFactory sessionFactory(LocalSessionFactoryBean localSessionFactoryBean) {
		return localSessionFactoryBean.getObject();
	}

}
