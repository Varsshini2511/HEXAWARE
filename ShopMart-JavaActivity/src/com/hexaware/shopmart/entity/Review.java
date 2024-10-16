package com.hexaware.shopmart.entity;

public class Review {

	private int rating;
	private String customer;
	
	public Review(int rating, String customer) {
		super();
		this.rating = rating;
		this.customer = customer;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Review [rating=" + rating + ", customer=" + customer + "]";
	}
	
	
}
