package com.hexaware.MainVehicleProgram;

import com.hexaware.abstractclasses.*;
import java.util.Scanner;


public class User {
	
    private String userName;
    private Vehicle[] rentedVehicles;  // Array to store rented vehicles
    private Vehicle[] availableVehicles; //Array to store available vehicles

    public User(String userName, Vehicle[] availableVehicles) {
        this.userName = userName;
        this.rentedVehicles = new Vehicle[availableVehicles.length]; 
        this.availableVehicles = availableVehicles;
    }

    
    //RENT VEHICLE
    public void rentVehicle() {
        Scanner sc = new Scanner(System.in);

        // Display available vehicles
        System.out.println("Available vehicles:");
        
        for (int i = 0; i < availableVehicles.length; i++) {
            if (!availableVehicles[i].isRented()) {
                System.out.println((i + 1) + ". " + availableVehicles[i].getVehicleName() + " Rs." + availableVehicles[i].getPrice() + " per day");                
            }
            
            System.out.println();
        }
        
        System.out.print("\nChoose a vehicle to rent: ");
        int vehicleToRent = sc.nextInt();

        if (vehicleToRent >= 1 && vehicleToRent <= availableVehicles.length && !availableVehicles[vehicleToRent - 1].isRented()) {
            availableVehicles[vehicleToRent - 1].rentVehicle();
            // Add rented vehicle to the first available slot in the rentedVehicles array
            for (int i = 0; i < rentedVehicles.length; i++) {
                if (rentedVehicles[i] == null) {
                    rentedVehicles[i] = availableVehicles[vehicleToRent - 1];
                    break;
                }
            }
        } else {
            System.out.println("Invalid choice or vehicle already rented.");
            return;
        }
        //sc.close();
    }

    
    
    // Return vehicle
    
    public void returnVehicle() {
        Scanner sc = new Scanner(System.in);

        if (rentedVehicles[0] == null) {
            System.out.println("You have not rented any vehicles.");
            //return;
        }

        // Display user's rented vehicles
        System.out.println("Your rented vehicles:");
    
        for (int i = 0; i < rentedVehicles.length; i++) {
            if (rentedVehicles[i] != null) {
                System.out.println((i + 1) + ". " + rentedVehicles[i].getVehicleName());
            }
        }

        System.out.print("Enter the number of the vehicle you want to return: ");
        int vehicleToReturn = sc.nextInt();

        if (vehicleToReturn >= 1 && vehicleToReturn <= rentedVehicles.length && rentedVehicles[vehicleToReturn - 1] != null) {
            rentedVehicles[vehicleToReturn - 1].returnVehicle();
            rentedVehicles[vehicleToReturn - 1] = null; // Remove the vehicle from the array
        } else {
            System.out.println("Invalid choice.");
        }
        
        //sc.close();
    }

    
    // VIEW RENTED VEHICLES
    
 /*   public void viewRentedVehicles() {
        if (rentedVehicles[0] == null) {
            System.out.println("You have not rented any vehicles.");
        } else {
            System.out.println("Your rented vehicles:");
            for (int i = 0; i < rentedVehicles.length; i++) {
                if (rentedVehicles[i] != null) {
                    System.out.println((i + 1) + ". " + rentedVehicles[i].getVehicleName());
                }
            }
        }
    }*/
    
    public void viewRentedVehicles() {
        boolean hasRentedVehicles = false;

        // Check if any vehicle has been rented (i.e., not null)
        for (Vehicle vehicle : rentedVehicles) {
            if (vehicle != null) {
                hasRentedVehicles = true;
                break;
            }
        }

        // If there are no rented vehicles, inform the user
        if (!hasRentedVehicles) {
            System.out.println("You have not rented any vehicles.");
            return;
        }

        // Display all rented vehicles
        System.out.println("Your rented vehicles:");
        for (int i = 0; i < rentedVehicles.length; i++) {
            if (rentedVehicles[i] != null) {
                System.out.println((i + 1) + ". " + rentedVehicles[i].getVehicleName());
            }
        }
    }

}
