package com.DataBase;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= "com")
public class Config {

	@Bean("dataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/notetaker");
		dataSource.setUsername("root");
		dataSource.setPassword("Trinmoy@1843");
		return dataSource;
	}
	
	@Bean("sessionFactory")
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(this.getDataSource());
		sessionFactory.setPackagesToScan("com");
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		sessionFactory.setHibernateProperties(props);
		return sessionFactory;
	}
	
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager trans = new HibernateTransactionManager();
		trans.setSessionFactory(this.getSessionFactory().getObject());
		return trans;
	}
	
}



























