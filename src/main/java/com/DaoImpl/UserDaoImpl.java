package com.DaoImpl;

import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.*;
import com.Model.User;
import com.configuration.HibernateConfig;

@Repository("UserDAO")
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	
	List<User> userslist;

	public UserDaoImpl() {

		userslist = new ArrayList<User>();
	//	User user1 = new User("Chetana", "Chetana@space.com", "9408180365", "Mumbai", "password", "india");
		//User user2 = new User("Jia", "Jia@space.com", "9408180365", "Mumbai", "password", "india");
		//userslist.add(user1);
		//userslist.add(user2);
	}
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
		try{
			HibernateConfig hbConfig = new HibernateConfig();
			SessionFactory session=hbConfig.getSessionFactory();
			Session ses = session.openSession();
			Query query=ses.createQuery("from User");
			List<User> userslist=query.list();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return userslist;
	}

	@Transactional
	public User getUser(String email) {
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,email);
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
