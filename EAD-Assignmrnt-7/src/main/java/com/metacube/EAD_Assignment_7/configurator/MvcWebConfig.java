package com.metacube.EAD_Assignment_7.configurator;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.metacube.EAD_Assignment_7.model.Login;
import com.metacube.EAD_Assignment_7.model.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.metacube.EAD_Assignment_7")
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class MvcWebConfig implements WebMvcConfigurer
{
	
	@Autowired
	Environment env;
	
	@Autowired
	private ApplicationContext applicationContext;

	//getting the properties from database.properties file in resource folder
	private final String URL = "url";
	private final String USER = "user";
	private final String DRIVER = "driver";
	private final String PASSWORD = "password";
	

	//resolves the template with the following prefix and suffix to the jsp page returned from the controller
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
	    InternalResourceViewResolver resolver= new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/pages/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	}  
	
	//returns the factory bean from the session factory of the hibernate
	@Bean
	public LocalSessionFactoryBean getSessionFactory() 
	{
	    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	    factoryBean.setDataSource(dataSource());
	    
	    Properties props = new Properties();
	    
	    // Setting Hibernate properties
	    props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	    props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

	    factoryBean.setHibernateProperties(props);
	    factoryBean.setAnnotatedClasses(Login.class,User.class);
	    
	    return factoryBean;
	  }
	
	
	//it returns the transaction manageer which handles the session of the hibernate
	@Bean
	public HibernateTransactionManager getTransactionManager() 
	{
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(getSessionFactory().getObject());
	    return transactionManager;
	}
	
	
	//it sets the database properties into the data source
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(env.getProperty(URL));
		driverManagerDataSource.setUsername(env.getProperty(USER));
		driverManagerDataSource.setPassword(env.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(env.getProperty(DRIVER));
		return driverManagerDataSource;
	}
	
}
