package com.Dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Model.Supplier;
import com.Model.User;


public interface SupplierDao {
	
	public boolean insertSupp(Supplier supplier);
	public boolean updateSupp(Supplier supplier);
	public boolean deleteSupp(Supplier supplier);
	public Supplier getSupplier(int sid);
	public HashMap<Integer,String> getAllSuppliers();
}
