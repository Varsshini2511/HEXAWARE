package com.hexaware.concreteclasses;

import com.hexaware.abstractclasses.Vehicle;

public class Truck extends Vehicle{

	public Truck(String vehicleName, double price) {
		super(vehicleName, price);
	}

	@Override
	public void vehicleDetails() {
		// TODO Auto-generated method stub
		System.out.println("Truck : "+ getVehicleName()+".\n Price : "+getPrice());
	}

	
}
