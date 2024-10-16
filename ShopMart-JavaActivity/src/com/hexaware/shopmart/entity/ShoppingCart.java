package com.hexaware.shopmart.entity;

import java.util.ArrayList;
import java.util.*;

public class ShoppingCart {

	
	    private List<Item> cartItems;

	    public ShoppingCart() {
	        this.cartItems = new ArrayList<>();
	    }

	    public void addItem(Item item) {
	        cartItems.add(item);
	        System.out.println(item.getItemName() + " added to cart.");
	    }

	    public void removeItem(Item item) {
	        cartItems.remove(item);
	        System.out.println(item.getItemName() + " removed from cart.");
	    }

	    public void listCartItems() {
	        System.out.println("Items in your cart:");
	        for (Item item : cartItems) {
	            System.out.println(item);
	        }
	    }

	    public void clearCart() {
	        cartItems.clear();
	        System.out.println("Shopping cart cleared.");
	    }

	    public List<Item> getCartItems() {
	        return cartItems;
	    }
	}
