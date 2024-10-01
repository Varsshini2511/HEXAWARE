package com.hexaware.concreteclasses;

import com.hexaware.abstractclasses.Vehicle;

public class Car extends Vehicle{

	public Car(String vehicleName, double price) {
		super(vehicleName, price);
	}

	@Override
	public void vehicleDetails() {
		// TODO Auto-generated method stub
		System.out.println("Car : "+ getVehicleName()+".\n Price : "+getPrice());
	}

	
	
}
