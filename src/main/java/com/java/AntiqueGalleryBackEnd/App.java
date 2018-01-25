package com.java.AntiqueGalleryBackEnd;


import com.DaoImpl.UserDaoImpl;
import com.Model.User;
import com.Dao.*;

public class App {
	public static void main(String args[])
	{
		UserDao userdao=new UserDaoImpl();
		
		  for (User user : userdao.getAllUsers()) {
		         System.out.println("User: [name : " + user.getName() + ", Email : " +user.getEmail() + " ]");
		      }
	}
}
