package com.Model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
//import org.hibernate.validator.constraints.*;
@Component 
@Entity
@Table(name="Supplier")
public class Supplier  implements Serializable {
	@Id
	private int sid;
	private String supplierName;
	@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER,mappedBy="supplier")
	private Set<Product> products=new HashSet<Product>(0);
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
