package com.hexaware.shopmart.entity;

public class CashPayment extends Payment {

	private double cashReceived;

	public CashPayment(String payerName, double amount, double cashReceived) {
		super(payerName, amount);
		this.cashReceived = cashReceived;
	}

	@Override
	public void processPayment() {
		// TODO Auto-generated method stub
		if (cashReceived >= amount) {
            System.out.println("Processing cash payment for " + payerName);
            System.out.println("Payment of " + amount + " was successful. Change: " + (cashReceived - amount));
        } else if(cashReceived == amount){
        	System.out.println("Payment of "+amount+" is successful");
        }
		else {
            System.out.println("Insufficient cash. Payment failed.");
        }
	}
	
	
}
