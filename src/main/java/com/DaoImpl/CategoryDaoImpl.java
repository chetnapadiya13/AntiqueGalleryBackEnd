package com.DaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CategoryDao;
import com.Model.Category;
import com.Model.User;
import com.configuration.HibernateConfig;

@Repository
@Service
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Category> showallCatList()
	{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionF=hbConfig.getSessionFactory();
			Session session=sessionF.openSession();
			Query query=session.createQuery("from Category");
			List<Category> category=(List<Category>) query.list();
			session.close();
			return category;
	}
	@Transactional//("txName")
	public void insertCategory(Category category) {
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
 
	@Transactional//("txName")
	public void updateCategory(String cid) {
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

	@Transactional//("txName")
	public void deleteCategory(String cid) {
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

	@Transactional//("txName")
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

	@Transactional//("txName")
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
	

/*	@Transactional//("txName")
	public HashMap<Integer,String> showallCategory() {
		// TODO Auto-generated method stub
		HibernateConfig hbConfig = new HibernateConfig();
		sessionFactory=hbConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Category> categoryList = (List<Category>) session.createQuery("from Category").list();
		HashMap<Integer,String> categoryMap = new HashMap<Integer, String>();
		for(Category category:categoryList)
		{
			categoryMap.put(category.getCid(),category.getCname());
		}
		session.close();
		return categoryMap;
	}
*/

	 @Transactional//("txName")
	public Category getCategory(String cid) {
		HibernateConfig hbConfig = new HibernateConfig();
		sessionFactory=hbConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query  cri = session.createQuery("from Category where cid="+cid);
		Category category = (Category) cri.getSingleResult();
		return category;
	}
	 
}	 
	 
