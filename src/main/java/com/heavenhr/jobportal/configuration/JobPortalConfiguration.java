package com.heavenhr.jobportal.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * 
 * @author AnilKumar
 *
 */

@Configuration
public class JobPortalConfiguration {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Bean
	@Primary
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.heavenhr.jobportal.entity");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
		hibernateProperties.put("hibernate.show_sql", true);
		hibernateProperties.put("hibernate.hbm2ddl.auto", "create");
		hibernateProperties.put("hibernate.current_session_context_class",
				"org.springframework.orm.hibernate5.SpringSessionContext");
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}

}
