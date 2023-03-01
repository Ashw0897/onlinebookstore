package com.book.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBook {
	
	static Connection con = null;
	
	

	public static Connection getConnection() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBookStore", "root", "root");
		return con;
	}
	
	public static void closeConnection()
	{
		if(con!=null)
		{
			try 
			{
				con.close();
			}
			catch(SQLException e)
			{
				System.out.println("Something went wrong");
			}
		}
	}


}
