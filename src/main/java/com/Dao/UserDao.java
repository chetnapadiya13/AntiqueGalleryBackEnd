package com.Dao;

import java.util.*;

import com.Model.*;

public interface UserDao {
	
	public List<User> getAllUsers();
	
	public boolean addUser(User user);
	
	public User getUser(String email);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);
}
