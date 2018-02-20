package com.DaoImpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CartDao;
import com.Model.*;
import com.configuration.HibernateConfig;

@Repository
@Service
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void insertCart(Cart cart) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(cart);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	@Transactional
	public List<Cart> findCartById(String email) 
	{
		// TODO Auto-generated method stub
		HibernateConfig hbConfig = new HibernateConfig();
		SessionFactory sessionF=hbConfig.getSessionFactory();
		Session session=sessionF.openSession();
		Query query=session.createQuery("from Cart where email=:email");
		query.setParameter("email",email);
		List<Cart> cartList=query.list();
		return cartList;
	}
	@Transactional
	public Cart getCartById(String email, int cartId) {
		// TODO Auto-generated method stub
		HibernateConfig hbConfig = new HibernateConfig();
		SessionFactory sessionF=hbConfig.getSessionFactory();
		Session session=sessionF.openSession();
		Query query=session.createQuery("from Cart where email=:email and cartId=:cartId");
		query.setParameter("email",email);
		query.setParameter("cartId", cartId);
		Cart cartList= (Cart) query.getSingleResult();
		return cartList;
	}
	@Transactional
	public void deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.delete(cart);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	@Transactional
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(cart);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}

	public void updateCartById(int cartId,Cart cart) {
		// TODO Auto-generated method stub
		try
		{
			HibernateConfig hbConfig = new HibernateConfig();
			sessionFactory=hbConfig.getSessionFactory();
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			//session.saveOrUpdate(cartId, cart);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		
	}
	public void updateCartById(String email) {
		// TODO Auto-generated method stub
		
	}

}
