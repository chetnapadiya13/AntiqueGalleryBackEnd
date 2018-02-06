package com.DaoImpl;

import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.*;
import com.Model.User;
import com.configuration.HibernateConfig;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional//("txName")
	public boolean addUser(User user)
	{
		
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
			Integer i=(Integer) session.save(user);
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
	public List<User> getAllUsers() {
		
		List<User> usersList = new ArrayList<User>();
		try{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory session=hbConfig.getSessionFactory();
			Session ses = session.openSession();
			Query query=ses.createQuery("from User");
			usersList = query.list();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return usersList;
	}

	@Transactional//("txName")
	public User getUser(String email) {
		HibernateConfig hbConfig = new HibernateConfig();
		SessionFactory sessionF=hbConfig.getSessionFactory();
		Session session=sessionF.openSession();
		Query query=session.createQuery("from User where email=:emailid");
		query.setParameter("emailid",email);
	//	User user=(User)session.get(User.class,email);
		User user=(User) query.uniqueResult();
		session.close();
		return user;
	}

	@Transactional//("txName")
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
			session.saveOrUpdate(user);
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
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory sessionfac=hbConfig.getSessionFactory();
			Session session=sessionfac.openSession();
			session.beginTransaction();
			session.delete(user);
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
}
