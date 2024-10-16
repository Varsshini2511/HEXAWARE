package com.hexaware.shopmart.entity;

public class CreditCardPayment extends Payment {

	private String cardNumber;
	

	public CreditCardPayment(String payerName, double amount, String cardNumber) {
		super(payerName, amount);
		this.cardNumber = cardNumber;
	}



	@Override
	public void processPayment() {
		// TODO Auto-generated method stub
		System.out.println("Processing credit card payment for " + payerName);
		
        System.out.println("Payment of " + amount + " was successful using card ending in " + cardNumber.substring(cardNumber.length() - 4));
	}

}
