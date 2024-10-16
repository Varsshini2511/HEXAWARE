package com.hexaware.shopmart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	/*//private static DBConnection instance;
	private static Connection connection;
	
	
	
	private static final String url = "jdbc:mysql://localhost:3306/shopMart";
	private static final String username = "root";
	private static final String password = "Varssh@2002";
	
	private DBConnection() throws ClassNotFoundException
	{
		
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection =  DriverManager.getConnection(url,username,password);
			
			System.out.println("Connection established");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	public static Connection getConnection()
	{
		return connection;
	}*/
	
	private static final String URL = "jdbc:mysql://localhost:3306/shopMart"; // Update with your DB URL
    private static final String USER = "root"; // Update with your DB username
    private static final String PASSWORD = "Varssh@2002"; // Update with your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
