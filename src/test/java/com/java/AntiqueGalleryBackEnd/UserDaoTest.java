package com.java.AntiqueGalleryBackEnd;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Model.*;
import com.Dao.*;
import com.DaoImpl.*;

public class UserDaoTest {

		static UserDao userDao;
		
		@Before
		public void setup()
		{
			userDao=new UserDaoImpl();
		}
		@After
		public void teardown()
		{
			userDao=null;
		}
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
			annotationConfigAppContext.scan("com");
			annotationConfigAppContext.refresh();
			
			userDao=(UserDao)annotationConfigAppContext.getBean("userDao");
		}
		@Ignore
		@Test
		void testadduser()
		{
			User user=new User();
			user.setId(10);
			user.setPassword("123");
			user.setEmail("xyz@abc.com");
			
			
			assertTrue("Problem in Adding user",userDao.addUser(user));
			
		}
		@Ignore
		@Test
		void testgetalluser(List<User> listUser)
		{
			for(User user:listUser)
			{
				System.out.println("User Id:"+user.getId());
				System.out.println("User Email :"+user.getEmail());
				System.out.println("User Name :"+user.getFirstName());
				System.out.println("User password :"+user.getPassword());
				
				
			}
			
		}
		@Ignore
		@Test
		void testgetuser()
		{
			String email="ch@gmail.com";
			List<User> listuser=(List<User>) userDao.getUser(email);
			assertNotNull("Problem in Listing user",listuser);
			this.testgetalluser(listuser);
		}
		@Ignore
		@Test
		void testupdateuser()
		{
			User user=new User();
			user.setId(101);
			user.setPassword("123");
			user.setEmail("xyz@abc.com");
			
			
			assertTrue("Problem in updating user",userDao.updateUser(user));
			
		}
		@Ignore
		@Test
		void testdeleteuser()
		{
			User user=new User();
			user.setId(101);
			user.setPassword("123");
			user.setEmail("xyz@abc.com");
			
			
			assertTrue("Problem in deleting user",userDao.deleteUser(user));
			
		}
		

}
