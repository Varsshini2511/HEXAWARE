package com.hexaware.MainVehicleProgram;

import com.hexaware.abstractclasses.*;
import com.hexaware.concreteclasses.*;
import java.util.*;

public class Main {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		Vehicle c1 = new Car("Benz", 25000);
		
		Vehicle b1 = new Bike("Yamaha", 15000);
		Vehicle t1 = new Truck("Bharath Benz", 30000);
		
		Vehicle[] v = {c1, b1,t1};
		
		System.out.println("Enter your name:");
		String userName = sc.nextLine();
		User user = new User(userName , v);
		
		
		int choice;
		
        do {
        	System.out.println("\n********User Option*******");
            System.out.println("\n1. Rent a Vehicle");
            System.out.println("\n2. Return a Vehicle");
            System.out.println("\n3. View Rented Vehicles");
            System.out.println("\n0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
          
            
            switch (choice) {
                case 1:
                    user.rentVehicle();
                    break;

                case 2:
                    user.returnVehicle();
                    break;

                case 3:
                    user.viewRentedVehicles();
                    break;

                case 0:
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
		
	
		
	}
	
}
