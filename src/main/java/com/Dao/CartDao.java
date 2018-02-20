package com.Dao;

import java.util.List;

import com.Model.Cart;

public interface CartDao {
	
	public void insertCart(Cart cart);
    public List<Cart> findCartById(String email);
    public Cart getCartById(String email,int cartId);
    public void deleteCart(Cart carrt);
    public void updateCart(Cart cart);
    public void updateCartById(String email);
    
}
