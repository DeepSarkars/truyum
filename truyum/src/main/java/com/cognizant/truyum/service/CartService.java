package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	public void addCartItem(String userId, long menuItemId) {
		cartDao.addCartItem(userId, menuItemId);
	}
	
	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException{
		return cartDao.getAllCartItems(userId);
	}
	
	public void removeCartItem(String userId, long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);
	}
}
