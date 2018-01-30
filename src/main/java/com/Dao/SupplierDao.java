package com.Dao;

import com.Model.Supplier;

public interface SupplierDao {
	
	public boolean insertSupp(Supplier supplier);
	public boolean updateSupp(Supplier supplier);
	public boolean deleteSupp(Supplier supplier);

}
