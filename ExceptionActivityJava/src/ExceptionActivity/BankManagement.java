package ExceptionActivity;

import java.util.*;

public class BankManagement {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BankAccount ba =null;
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\nBank Account Management Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        if (ba != null) {
                            System.out.println("Account already exists.");
                        } else {
                            ba = new BankAccount();
                            System.out.println("New account created.");
                        }
                        break;

                    case 2:
                        if (ba == null) {
                        	throw new NullPointerException("No account created yet.");
                        }
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        ba.deposit(depositAmount);
                        break;

                    case 3:
                        if (ba == null) {
                        	throw new NullPointerException("No account created yet.");
                        }
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        ba.withdraw(withdrawAmount);
                        break;

                    case 4:
                        if (ba == null) {
                        	throw new NullPointerException("No account created yet.");
                        }
                        ba.checkBalance();
                        break;

                    case 5:
                        exit = true;
                        System.out.println("Exiting the system. Thank you!");
                        break;

                    default:
                        throw new InvalidChoice("Invalid choice. Please select a valid option.");
                }

            } catch (InvalidAmount | LowBalance | InvalidChoice e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
                sc.next();  // Clear the invalid input
            }
        }

        sc.close();
    }
}
