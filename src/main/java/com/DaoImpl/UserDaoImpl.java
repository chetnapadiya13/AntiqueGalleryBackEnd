package com.DaoImpl;

import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.*;
import com.Model.User;
import com.configuration.HibernateConfig;

@Repository("UserDAO")
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addUser(User user)
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	
	@Transactional
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

	@Transactional
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

	@Transactional
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;	
		}

	}

	@Transactional
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;	
		}

	}
}
