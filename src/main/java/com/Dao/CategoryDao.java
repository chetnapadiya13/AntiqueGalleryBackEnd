package com.Dao;

import com.Model.Category;

import com.Model.User;

import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface CategoryDao {
	public void insertCategory(Category category);
	public void updateCategory(String cid);
	public void deleteCategory(String cid);
	public void updateCategory(Category category);
	public void deleteCategory(Category category);
	//public HashMap<Integer,String> showallCategory();
	public List<Category> showallCatList();	
	public Category getCategory(String cid);
}
