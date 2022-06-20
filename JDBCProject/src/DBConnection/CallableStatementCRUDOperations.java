package DBConnection;
import java.sql.*;

import java.util.*;
public class CallableStatementCRUDOperations {
	public static void main(String args[])
	{
		CallableStatementCRUDOperations operations = new CallableStatementCRUDOperations();
		//operations.createtable();
		//operations.insertrecord();
		//operations.displayrecords();
		//operations.updaterecord();
		operations.deleterecord();
		
		
	}
	public void createtable()
	  {
	    try
	    {
	      Connection con=DBConnection.getConnection();
	      CallableStatement callableStatement=con.prepareCall("{ call createtable() }");
	      callableStatement.execute();
	      System.out.println("Table created Successfully");
	      callableStatement.close();
	      con.close();
	    }
	    catch(Exception e)
	    {
	      System.out.println(e);
	    }
	  }
	public void insertrecord()
	  {
	    try
	    {
	      Connection con=DBConnection.getConnection();
	      CallableStatement cstmt = con.prepareCall("  { call insertrecord(?,?,?,?,?)  }  ");
	      
	      int id=31799,year=2017;
	      String name="adil",gender="FEMALE";
	      Double salary=12000.50;
	      
	      
	      cstmt.setInt(1, id);
	      cstmt.setString(2, name);
	      cstmt.setString(3, gender);
	      cstmt.setDouble(4, salary);
	      cstmt.setInt(5, year);
	      
	      int result = cstmt.executeUpdate();
	      
	      if(result>0)
	        System.out.println(result+" Record Inserted Successfully");
	      else
	        System.out.println("Failed to Insert Record");
	      
	      cstmt.close();
	      con.close();
	      
	    }
	    catch(Exception e)
	    {
	      System.out.println(e);
	    }
	  }
	public void updaterecord()
	  {
	    try
	    {
	      Connection con=DBConnection.getConnection();
	      CallableStatement cstmt = con.prepareCall("  { call updaterecord(?,?,?)  }  ");
	      
	      int id=101;
	      String gender="F";
	      Double salary=13000.50;
	      
	      
	      cstmt.setInt(1, id);
	      cstmt.setString(2, gender);
	      cstmt.setDouble(3, salary);
	      
	      int result = cstmt.executeUpdate();
	      
	      if(result>0)
	        System.out.println(result+" Record Updated Successfully");
	      else
	        System.out.println("Failed to Update Record");
	      
	      cstmt.close();
	      con.close();
	      
	    }
	    catch(Exception e)
	    {
	      System.out.println(e);
	    }
	  }
	public void deleterecord()
	  {
	    try
	    {
	      Connection con=DBConnection.getConnection();
	      CallableStatement cstmt = con.prepareCall("  { call deleterecord(?)  }  ");
	      
	      int id=101;
	    
	      cstmt.setInt(1, id);
	      
	      int result = cstmt.executeUpdate();
	      
	      if(result>0)
	        System.out.println(result+" Record Deleted Successfully");
	      else
	        System.out.println("Failed to Delete Record");
	      
	      cstmt.close();
	      con.close();
	      
	    }
	    catch(Exception e)
	    {
	      System.out.println(e);
	    }
	  }
	public void displayrecords()
	  {
	    try
	    {
	      Connection con=DBConnection.getConnection();
	      CallableStatement cstmt = con.prepareCall("  { call displayrecords()  }  ");
	      
	      ResultSet rs = cstmt.executeQuery();
	      
	      while(rs.next())
	      {
	        System.out.println("Faculty ID="+rs.getInt(1));
	        System.out.println("Faculty Name="+rs.getString(2));
	        System.out.println("Faculty Gender="+rs.getString(3));
	        System.out.println("Faculty Salary="+rs.getDouble(4));
	        System.out.println("Faculty Year of joining="+rs.getInt(5));
	      }
	      
	    }
	    catch(Exception e)
	    {
	      System.out.println(e);
	    }
	  }

}
