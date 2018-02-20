package com.Model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service 
@Component 
@Entity(name="Cart")
public class Cart implements Serializable  {
	
	@Id
	@GeneratedValue
	private int cartId;
	
	@Column(name="cartProductId")
	private int cartProductId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="email")
	private User userEmail;
	
	@Column(name="cartPrice")
	private double cartPrice;
	
	@Column(name="cartQty")
	private int cartQty;
	
	@Column(name="cartImage")
	private String cartImage;
	
	@Column(name="cartProductName")
	private String cartProductName;
	
	public Cart(){super();}

	public Cart(int cartId, int cartProductId, User userEmail, double cartPrice, int cartQty, String cartImage,
			String cartProductName) {
		super();
		this.cartId = cartId;
		this.cartProductId = cartProductId;
		this.userEmail = userEmail;
		this.cartPrice = cartPrice;
		this.cartQty = cartQty;
		this.cartImage = cartImage;
		this.cartProductName = cartProductName;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public User getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(User userEmail) {
		this.userEmail = userEmail;
	}

	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCartQty() {
		return cartQty;
	}

	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}

	public String getCartImage() {
		return cartImage;
	}

	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}

	public String getCartProductName() {
		return cartProductName;
	}

	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	
	
	
	
}
