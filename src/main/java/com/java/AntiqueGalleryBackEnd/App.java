package com.java.AntiqueGalleryBackEnd;


import com.DaoImpl.UserDaoImpl;
import com.Model.User;

import java.util.List;

import com.Dao.*;

public class App {
	public static void main(String args[])
	{
		UserDao userdao=new UserDaoImpl();
		List<User> userList = userdao.getAllUsers(); 
		
		System.out.println(userList.size());
		System.out.println(userList.get(0).getEmail());
		  for (User user : userList) {
		         System.out.println("User: [name : " + user.getName() + ", Email : " +user.getEmail() + " ]");
		      }
	}
}
