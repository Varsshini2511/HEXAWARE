package com.hexaware.shopmart.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.shopmart.entity.Item;
import com.hexaware.shopmart.util.DBConnection;

public class ItemDaoImpl implements ItemDao {

	/*public final Connection con ;//=DBConnection.getConnection();
	
	
	
	public ItemDaoImpl() throws SQLException {
		super();
		this.con = DBConnection.getConnection();
	}
*/


	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		//con =DBConnection.getConnection();
		String query = "Insert into items(itemName, price, category) VALUES (?, ?, ?)";
		
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);

			 	ps.setString(1, item.getItemName());
	            ps.setDouble(2, item.getPrice());
	            ps.setString(3, item.getCategory());
	            int i = ps.executeUpdate();
	            if(i>0) {
	            System.out.println("Item added successfully.");
	            }
	        } catch (SQLException e) {
	            System.err.println("Error adding item: " + e.getMessage());
	        }
		
		
	}
	
	

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		String query = "UPDATE items SET price = ?, category = ? WHERE itemName = ?";
		
        try  {
        	Connection con = DBConnection.getConnection();
        	PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, item.getPrice());
            ps.setString(2, item.getCategory());
            ps.setString(3, item.getItemName());
            int i = ps.executeUpdate();
            if(i>0) {
            System.out.println("Item updated successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating item: " + e.getMessage());
        }
    }
		


	@Override
	public void deleteItem(String itemName) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM items WHERE itemName = ?";
		
        try {
        	Connection con = DBConnection.getConnection();
        	PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, itemName);
            int i =ps.executeUpdate();
            if(i>0) {
            System.out.println("Item deleted successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting item: " + e.getMessage());
        }
	}

	@Override
	public List<Item> listAllItems() {
		// TODO Auto-generated method stub
		List<Item> items = new ArrayList<>();
		
        String query = "SELECT * FROM items";
        
        try {
        	Connection con = DBConnection.getConnection();
        	Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             
            while (rs.next()) {
                String itemName = rs.getString("itemName");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                items.add(new Item(itemName, price, category));
            }
        } catch (SQLException e) {
            System.err.println("Error listing items: " + e.getMessage());
        }
        return items;
	}

	@Override
	public Item getItemByName(String itemName) {
		// TODO Auto-generated method stub
		 String query = "SELECT * FROM items WHERE itemName = ?";
	        try {
	        	Connection con = DBConnection.getConnection();
	        	PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, itemName);
	        	
	            ResultSet rs = ps.executeQuery();
	            
	            if (rs.next()) {
	                double price = rs.getDouble("price");
	                String category = rs.getString("category");
	                return new Item(itemName, price, category);
	            }
	        } catch (SQLException e) {
	            System.err.println("Error retrieving item: " + e.getMessage());
	        }
	        return null;
	}

}
