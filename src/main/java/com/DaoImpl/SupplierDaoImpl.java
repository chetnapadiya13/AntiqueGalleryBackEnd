package com.DaoImpl;
import com.Model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Dao.SupplierDao;
import com.configuration.HibernateConfig;

@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional//("txName")
	public boolean insertSupp(Supplier supplier) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.save(supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	@Transactional//("txName")
	public boolean updateSupp(Supplier supplier) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.saveOrUpdate(supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	@Transactional//("txName")
	public boolean deleteSupp(Supplier supplier) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
		    session.delete(supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	@Transactional//("txName")
	public List<Supplier> getAllSuppliers() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Supplier> query = session.createQuery("FROM Supplier");
		List<Supplier> supplierList = query.list();
		session.getTransaction().commit();
		return supplierList;
	}
	public Supplier getSupplier(String sid) {
		HibernateConfig hbConfig = new HibernateConfig();
		sessionFactory=hbConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Supplier supplier = session.get(Supplier.class, sid);
		session.getTransaction().commit();
		return supplier;
	}
	

}


