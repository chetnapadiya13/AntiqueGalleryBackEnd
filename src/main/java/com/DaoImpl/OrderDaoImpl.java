package com.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.OrderDao;
import com.Model.Order;
import com.configuration.HibernateConfig;

@Repository
@Service
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void insertOrder(Order order)
	{
		
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
	}

}
