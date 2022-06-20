package DBConnection;
import java.sql.*;


public class TestConnection 
{
	public static void  main(String[] args)
	{
		try
		{
			Connection con =null;
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("driver class loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false", "root", "Sailu@123");
			System.out.print("connection established sucessfully\n");
			System.out.println(con);
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
	}	
	
}
