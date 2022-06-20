package DBConnection;

import java.sql.*;


public class DBConnection {
	public static Connection getConnection()
	{
		Connection con =null;

		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
 		    System.out.println("Driver Class Loaded");
 		    
 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false","root", "Sailu@123");
 		System.out.println("Connection Established Successfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return con;
		
		
	}


}
