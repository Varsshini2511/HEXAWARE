package com.hexaware.concreteclasses;

import com.hexaware.abstractclasses.Vehicle;

public class Bike extends Vehicle{

	public Bike(String vehicleName, double price) {
		super(vehicleName, price);
	}

	@Override
	public void vehicleDetails() {
		// TODO Auto-generated method stub
		System.out.println("Bike : "+ getVehicleName()+".\n Price : "+getPrice());
	}
	
	
}
