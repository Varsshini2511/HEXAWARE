package com.hexaware.shopmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.shopmart.entity.Order;
import com.hexaware.shopmart.util.DBConnection;

public class OrderDaoImpl implements OrderDao {

	/*public final Connection con;
	
	public OrderDaoImpl() throws SQLException {
		con = DBConnection.getConnection();
	}
*/
	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO orders (orderID, totalPrice) VALUES (?, ?)";
		
        try {
        	Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, order.getOrderId());
            ps.setDouble(2, order.getTotalPrice());
            int i = ps.executeUpdate();
            if(i>0) {
            System.out.println("Order added successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding order: " + e.getMessage());
        }
	}

	@Override
	public List<Order> getOrderHistory(String userID) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE userID = ?";
        
        try {
        	Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String orderID = rs.getString("orderID");
                double totalPrice = rs.getDouble("totalPrice");
                orders.add(new Order(orderID, new ArrayList<>(), totalPrice)); // Assuming item list retrieval is handled separately
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving order history: " + e.getMessage());
        }
        return orders;
	}

	

}
