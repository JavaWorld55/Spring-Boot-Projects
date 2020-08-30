package com.shubh.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shubh.model.Library;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableTransactionManagement
public class DBConfig {
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	//@Value("${jdbc.dialect}")
	//private String dialect;
	//@Value("${jdbc.hibernate.hbm2ddl}")
	//private String hbm2ddl;
	
	@Bean
	public DataSource getDataSource() {
		System.out.println("datasource object");
		DriverManagerDataSource ds=new DriverManagerDataSource(url, username, password);
		ds.setDriverClassName(driverClassName);
		return ds;
	}
	
	public Properties hibernateProperties() {
		System.out.println("properties obbject");
		Properties prop=new Properties();
		//prop.putIfAbsent("hibernate.dialect", dialect);
		prop.putIfAbsent("hibernate.show_sql", true);
		prop.putIfAbsent("hibernate.format_sql", true);
		//prop.putIfAbsent("hibernate.hbm2ddl.auto",hbm2ddl);
		return prop;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		System.out.println("localsession factory object");
		LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(hibernateProperties());
		//factory.setPackagesToScan(new String[] {"com.shubh.model.Library"});
		factory.setAnnotatedClasses(new Class[] {Library.class});
		
		return factory;
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager hibernateTransaction() {
		System.out.println("transaction object");
		HibernateTransactionManager tx=new HibernateTransactionManager();
		tx.setSessionFactory(sessionFactory().getObject());
		System.out.println(tx.getSessionFactory());
		return tx;
	}

}
