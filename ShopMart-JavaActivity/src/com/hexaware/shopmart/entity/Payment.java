package com.hexaware.shopmart.entity;

public abstract class Payment {

	protected String payerName;
	protected double amount;
	
	public Payment(String payerName, double amount) {
		super();
		this.payerName = payerName;
		this.amount = amount;
	}
	

	public abstract void processPayment();
}
