package com.configuration;
import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Model.Category;
import com.Model.Product;
import com.Model.Supplier;
import com.Model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com")
public class HibernateConfig 
{
	public static SessionFactory sessionFactory = null;
	
	//Creating a DataSource Bean
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource driverMgrDataSource=new DriverManagerDataSource();
		driverMgrDataSource.setDriverClassName("org.h2.Driver");
		driverMgrDataSource.setUrl("jdbc:h2:tcp://localhost/~/AntiqueGalleryDB");
		driverMgrDataSource.setUsername("sa");
		driverMgrDataSource.setPassword("");
		return driverMgrDataSource;
	}
	
	//Session Factory Bean Created.
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFacBuilder=null;
	
		try{
		Properties hibernateProperties=new Properties();
		hibernateProperties.put("hibernate.temp.use_jdbc_metadata_defaults","false");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto","none");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		localSessionFacBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		localSessionFacBuilder.addProperties(hibernateProperties);
		//localSessionFacBuilder.scanPackages("com.Model");
		localSessionFacBuilder.addAnnotatedClass(User.class);
		localSessionFacBuilder.addAnnotatedClass(Category.class);
		localSessionFacBuilder.addAnnotatedClass(Supplier.class);
		localSessionFacBuilder.addAnnotatedClass(Product.class);
		sessionFactory=localSessionFacBuilder.buildSessionFactory();
		System.out.println("Session Factory Object Created");
		
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		return sessionFactory;
		
	}
	
	//Transaction Bean Object
	@Autowired 
	@Bean //(name="txName")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTranMgr=new HibernateTransactionManager();
		hibernateTranMgr.setSessionFactory(sessionFactory);
		return hibernateTranMgr;
	}
	
}

