package com.Model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.validator.constraints.*;

@Entity
@Table(name = "Supplier")

public class Supplier  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @Column(name="id")
	private int id;
	
	@Column(name = "sid")
	private String sid;
	
	@Column(name = "supplierName")
	private String supplierName;
	
	public Supplier(){super();}
	public Supplier(int id,String sid,String supplierName)
	{
		super();
		this.id=id;
		this.sid=sid;
		this.supplierName=supplierName;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

}
