package com.heavenhr.jobportal.configuration;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
/**
 * 
 * @author AnilKumar
 *
 */
@Configuration
public class JobPortalTransactionConfiguration {

	@Autowired
	DataSource dataSource;

	@Autowired
	SessionFactory sessionFactory;

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setDataSource(dataSource);
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

}
