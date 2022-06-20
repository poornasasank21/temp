package DBConnection;

import java.sql.*;

public class StatementCRUDOperations 
{
     public static void main(String args[])
     {
    	 StatementCRUDOperations crudOperations = new StatementCRUDOperations();
    	 //crudOperations.createtable();
    	 //crudOperations.insertrecord();
    	//crudOperations.updaterecord();
    	// crudOperations.deleterecord();
  	 crudOperations.displayrecords();
    	 //crudOperations.totalrecordscount();
    	 
     }
     
     public void createtable()
     {
    	 try
    	 {
    		 Connection con = DBConnection.getConnection();
        	 
        	 //creating a statement
    		 Statement stmt = con.createStatement();
    		 
    	String qry = "  create table employee(id int primary key, name varchar(100) not null, gender varchar(10) not null, department varchar(100)\r\n"
    			+ "not null,salary decimal(10,4) not null);  "	;   
    	
    	
    int n = 	stmt.executeUpdate(qry);
    
    System.out.println(n+" Table Created");
    		 
        	 
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
    		 Connection con = DBConnection.getConnection();
    		 Statement stmt = con.createStatement();
    		 
    		 int id=1003;
    		 String name="surya";
    		 String gender="MALE";
    		String dept="MCA";		 
    		Double salary=30000.50;
    		
    		
       int n = stmt.executeUpdate(" insert into employee values( "+id+" , '"+name+"' , '"+gender+"' , '"+dept+"' , "+salary+"  )  ");		
    		 
       System.out.println(n+" Records Inserted");
       
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
    		 
                Connection con = DBConnection.getConnection();
        		 Statement stmt = con.createStatement();
        		 
        		 int id=101;
        		
        		 String gender="MALE";
        		String dept="CSE";		 
        		Double salary=15000.50;
        		 
        	int n = 	 stmt.executeUpdate(" update employee set gender='"+gender+"' , department='"+dept+"' , salary = "+salary+"  where id="+id+"   ");
        		 
       	 
            System.out.println(n+" Record(s) Updated");
            
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

             Connection con = DBConnection.getConnection();
     		 Statement stmt = con.createStatement();
     		 
     		 int id=1003;
     		 

     int n = stmt.executeUpdate("  delete from employee where id = "+id+"  "); 	
     
     System.out.println(n+" Record(s) Deleted");
     
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
    		 Connection con = DBConnection.getConnection();
     		 Statement stmt = con.createStatement();
     		 
     		
     		
     	//	ResultSet rs =  stmt.executeQuery("select * from employee");
     		 
     		ResultSet rs =  stmt.executeQuery("select id,salary from employee");
     		
     		System.out.println("Current Row Position="+rs.getRow());
//     		rs.next();
     		while(rs.next())
     		{
     			System.out.println("Employee ID:"+rs.getInt(1));
     			System.out.println("Employee Salary:"+rs.getDouble(2));
     			
 //    			System.out.println("Employee Id:"+rs.getInt(1));
 //    			System.out.println("Employee Name:"+rs.getString(2));
//     			System.out.println("Employee Gender:"+rs.getString(3));
//     			System.out.println("Employee Department:"+rs.getString(4));
//     			System.out.println("Employee Salary:"+rs.getDouble(5));
     			
//     			System.out.println("Employee ID:"+rs.getInt("id"));
//     			System.out.println("Employee Name:"+rs.getString("name"));
//     			System.out.println("Employee Gender:"+rs.getString("gender"));
//     			System.out.println("Employee Department:"+rs.getString("department"));
//     			System.out.println("Employee Salary:"+rs.getDouble("salary"));
     		}
     		 
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
     public void totalrecordscount()
     {
    	 try
    	 {
    		 Connection con = DBConnection.getConnection();
     		 Statement stmt = con.createStatement();
     		 
//     		 ResultSet rs=stmt.executeQuery(" select count(*)  from employee");
     		 ResultSet rs=stmt.executeQuery(" select count(*) as total  from employee");
     		 int count=0;
     		 if(rs.next())
     		 {
//     			 count=rs.getInt(1);
     			count=rs.getInt("total");
     			 
     		 }
     		 System.out.println("Total number of employee records = " +count);
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
}
