package com.java.AntiqueGalleryBackEnd;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Model.*;
import com.Dao.*;
import com.DaoImpl.*;
public class SupplierDaoTest {
	
	
	private static SupplierDao supplierDao;
	@Before
	public void setup()
	{
		supplierDao=new SupplierDaoImpl();
	}
	@After
	public void teardown()
	{
		supplierDao=null;
	}
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com");
		annotationConfigAppContext.refresh();
		
		supplierDao=(SupplierDao)annotationConfigAppContext.getBean("SupplierDao");
	}
	@Ignore
	@Test
	public void insertSupplierTest()
	{
		Supplier supplier=new Supplier();
	//	supplier.setId(102);
		supplier.setSid("102");
		supplier.setSupplierName("xyz");
		
		assertTrue("Problem in Adding supplier",supplierDao.insertSupp(supplier));
	}
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=new Supplier();
	//	supplier.setId(102);
		supplier.setSid("102");
		supplier.setSupplierName("xyz");
		
		assertTrue("Problem in Adding supplier",supplierDao.updateSupp(supplier));
	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=new Supplier();
	//	supplier.setId(102);
		supplier.setSid("102");
		supplier.setSupplierName("xyz");
		
		assertTrue("Problem in Adding supplier",supplierDao.deleteSupp(supplier));
	}

}
