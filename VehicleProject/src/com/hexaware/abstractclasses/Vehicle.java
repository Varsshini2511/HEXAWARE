package com.hexaware.abstractclasses;

public abstract class Vehicle {

	private String vehicleName;
	private double price;
	private boolean isRented = false;
	
	public Vehicle(String vehicleName, double price) {
		super();
		this.vehicleName = vehicleName;
		this.price = price;
		//this.isRented = isRented;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public void rentVehicle() {
		if(!isRented) {
			isRented = true;
			System.out.println("\n"+vehicleName+ " is rented for "+price);
		}
		else {
			System.out.println("\n"+vehicleName+" is not available.");
		}
	}
	
	public void returnVehicle() {
		if(isRented) {
			isRented = false;
			System.out.println("\n"+vehicleName+" is returned");
		}
		else {
			System.out.println("\n"+vehicleName + "is not rented and available for rent");
		}
	}
	
	public abstract void vehicleDetails();
	
}
