package com.wha.springmvc.configuration;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.objenesis.strategy.PlatformDescription;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
public class JPAConfiguration
{
	@Autowired
	private Environment environement;
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environement.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environement.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environement.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environement.getRequiredProperty("jdbc.password"));
		
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[] { "com.wha.springmvc.model" });
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.setJpaProperties(jpaProperties());
		
		return factoryBean;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter hibernateVendorAdapter = new HibernateJpaVendorAdapter();
		
		return hibernateVendorAdapter;
	}
	
	private Properties jpaProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environement.getRequiredProperty("hibernate.dialect"));
		//Autogen
		properties.put("hibernate.hbm2ddl.auto", environement.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environement.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environement.getRequiredProperty("hibernate.show_sql"));
		
		return properties;
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager (EntityManagerFactory emf)
	{
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(emf);
		return txm;
	}
	
	
}
