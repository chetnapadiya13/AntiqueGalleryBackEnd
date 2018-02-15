package com.Dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Model.Product;

@Repository
@Service("productDao")
public interface ProductDao {

	public void insertProduct(Product product);
	public void updateProduct(int pid);
	public void deleteProduct(int pid);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
	public List<Product> showallProduct();
	public Product getProduct(int pid);
	
}
