package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CategoryDao;
import com.Model.Category;
import com.configuration.HibernateConfig;

@Repository
@Service
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Bean
	@Transactional("txName")
	public void insertCategory(Category category) {
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Integer i=(Integer) session.save(category);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	@Bean 
	@Transactional("txName")
	public void updateCategory(int cid) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(cid);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	@Bean
	@Transactional("txName")
	public void deleteCategory(int cid) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.delete(cid);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
	}
	@Bean
	@Transactional("txName")
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(category);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	@Bean
	@Transactional("txName")
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.delete(category);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	 @Autowired
	@Bean
	@Transactional("txName")
	public List<Category> showallCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	 @Autowired
	@Bean
	 @Transactional("txName")
	public Category getCategory(String cid) {
		// TODO Auto-generated method stub
		return null;
	}
	 @Autowired
	@Transactional("txName")
	public Category getCategory(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
