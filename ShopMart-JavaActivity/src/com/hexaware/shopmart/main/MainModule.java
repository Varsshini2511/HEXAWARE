package com.hexaware.shopmart.main;

import java.sql.SQLException;
import java.util.*;

import com.hexaware.shopmart.dao.*;

import com.hexaware.shopmart.entity.*;

public class MainModule {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Order> orderHistory = new ArrayList<>(); // to store order history

        // Initialize DAOs (assuming implementation classes are defined)
        ItemDao itemDAO = new ItemDaoImpl();
        OrderDao orderDAO = new OrderDaoImpl();
        
        while (true) {
            System.out.println("\n===== ShopSmart Menu =====");
            System.out.println("1. Browse Items");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. Remove Item from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. Make Payment");
            System.out.println("7. Leave a Review");
            System.out.println("8. View Order History");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Browse Items
                    System.out.println("Available Items:");
                    List<Item> items = itemDAO.listAllItems();
                    for(Item i1 : items) {
                    	System.out.println(i1);
                    }
                    break;

                case 2:
                    // Add Item to Cart
                    System.out.println("Enter the item name to add to cart:");
                    String addItemName = sc.nextLine();
                    
                    Item itemToAdd = itemDAO.getItemByName(addItemName); // Assuming this method exists
                    if (itemToAdd != null) {
                        shoppingCart.addItem(itemToAdd);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    // Remove Item from Cart
                    System.out.println("Enter the item name to remove from cart:");
                    String removeItemName = sc.nextLine();
                    Item itemToRemove = itemDAO.getItemByName(removeItemName); // Assuming this method exists
                    if (itemToRemove != null) {
                        shoppingCart.removeItem(itemToRemove);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 4:
                    // View Cart
                    shoppingCart.listCartItems();
                    break;

                case 5:
                    // Place Order
                    if (shoppingCart.getCartItems().isEmpty()) {
                        System.out.println("Your cart is empty. Add items to the cart before placing an order.");
                    } else {
                        System.out.println("Enter your order ID:");
                        String orderID = sc.nextLine();
                        Order order = new Order(orderID, shoppingCart.getCartItems());
                        orderHistory.add(order);
                        System.out.println("Order placed successfully with ID: " + orderID);
                        shoppingCart.clearCart(); // Clear the cart after placing the order
                    }
                    break;

                case 6:
                    // Make Payment
                    System.out.println("Enter your name:");
                    String payerName = sc.nextLine();
                    System.out.println("Enter the amount to pay:");
                    double amount = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    System.out.println("Select payment method (1: Credit Card, 2: Cash):");
                    int paymentMethod = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    if (paymentMethod == 1) {
                        System.out.println("Enter your credit card number:");
                        String cardNumber = sc.nextLine();
                        Payment payment = new CreditCardPayment(payerName, amount, cardNumber);
                        payment.processPayment();
                    } else if (paymentMethod == 2) {
                        System.out.println("Enter cash received:");
                        double cashReceived = sc.nextDouble();
                        Payment payment = new CashPayment(payerName, amount, cashReceived);
                        payment.processPayment();
                    } else {
                        System.out.println("Invalid payment method selected.");
                    }
                    break;

                case 7:
                    // Leave a Review
                    System.out.println("Enter your rating (1-5):");
                    int rating = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter your review comment:");
                    String comment = sc.nextLine();
                    Review review = new Review(rating, comment);
                    System.out.println("Thank you for your review: " + review);
                    break;

                case 8:
                    // View Order History
                    System.out.println("Order History:");
                    orderHistory.forEach(order -> {
                        System.out.println("Order ID: " + order.getOrderId() + ", Total Price: " + order.getTotalPrice());
                    });
                    break;

                case 9:
                    // Exit
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        
        }

	}
}
