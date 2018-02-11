package com.java.AntiqueGalleryBackEnd;


import com.DaoImpl.*;
import com.Model.*;

import java.util.List;

import com.Dao.*;

public class App {
	public static void main(String args[])
	{
		/*UserDao userdao=new UserDaoImpl();
		List<User> userList = userdao.getAllUsers(); */
		SupplierDao supplierdao= new SupplierDaoImpl();
		Supplier supplier =new Supplier();
	//	supplier.setId(101);
		supplier.setSid(106);
		supplier.setSupplierName("chetana");
		System.out.println(supplierdao.insertSupp(supplier));
		/*System.out.println(userList.size());
		System.out.println(userList.get(0).getEmail());*/
		  /*for (User user : userList) {
		         System.out.println("User: [name : " + user.getName() + ", Email : " +user.getEmail() + " ]");
		      } */
	}
}
