package com.DaoImpl;

import java.util.List;
import com.Model.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.ProductDao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.configuration.HibernateConfig;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional//("txName")
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
			Integer i=(Integer) session.save(product);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	@Transactional//("txName")
	public void updateProduct(int pid) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
			session.saveOrUpdate(pid);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	@Transactional//("txName")
	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
			session.delete(pid);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
	}
	@Transactional//("txName")
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
			session.saveOrUpdate(product);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	@Transactional//("txName")
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	@Transactional//("txName")
	public List<Product> showallProduct() {
		HibernateConfig hbConfig = new HibernateConfig();
		SessionFactory sessionF=hbConfig.getSessionFactory();
		Session session=sessionF.openSession();
		Query query=session.createQuery("from product");
		List<Product> product=query.list();
		session.close();
		return product;
	}
	@Transactional//("txName")
	public Product getProduct(int pid) {
		HibernateConfig hbConfig = new HibernateConfig();
		SessionFactory sessionF=hbConfig.getSessionFactory();
		Session session=sessionF.openSession();
		Query query=session.createQuery("from Product where pid=:pid");
		query.setParameter("pid",pid);
		Product product=(Product) query.uniqueResult();
		return product;
	}

}
