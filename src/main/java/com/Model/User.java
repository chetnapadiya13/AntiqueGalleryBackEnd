package com.Model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "User")
public class User implements Serializable {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="id")
    private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Email 
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="password")
	private String password;
	
	@Column(name="country")
	private String country;

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User() {
		super();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Long id, String email, String name, String phone, String address, String password, String country) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.country = country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getCountry() {
		return country;
	}

}
