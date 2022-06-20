package DBConnection;

import java.sql.*;
import java.util.*;


public class PrepareStatementCRUDOperations {

  public static void main(String args[])
  {
    PrepareStatementCRUDOperations crudoperations = new PrepareStatementCRUDOperations();
    //crudoperations.createtable();
    //crudoperations.insertrecords();
    //crudoperations.updaterecord();
    //crudoperations.displayrecords();
    //crudoperations.deleterecord();
    crudoperations.totalrecordscount();
  }
  public void createtable()
  {
    try
    {
      Connection con = DBConnection.getConnection();
      PreparedStatement pstmt = con.prepareStatement("create table studentprep(sid int primary key,sname varchar(100) not null,sgender varchar(10) not null,sdept varchar(10) not null,sprogram varchar(100),scgpa decimal(10,4), semail varchar(100) unique not null)");
      pstmt.execute();
            
            System.out.println("Table Created Successfully");
            
            con.close();
          }
          catch(Exception e)
          {
            System.out.println(e);
          }
          
        }
  public void insertrecords()
    {
      try
      {
        Connection con = DBConnection.getConnection();
        
        int sid=0;
        String sname=null,sgender=null,sdept=null,sprogram=null,semail=null;
        Double scgpa=0.0;
        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Enter number of records to be inserted:");
        int n = sc.nextInt();
        
        PreparedStatement pstmt = con.prepareStatement(" insert into student values(?,?,?,?,?,?,?) ");
        
        for(int i=1;i<=n;i++)
        {
          System.out.println("Enter Student ID:");
          sid = sc.nextInt();
          System.out.println("Enter Student Name:");
          sname=sc.next();
          System.out.println("Enter Student Gender:");
          sgender=sc.next();
          System.out.println("Enter Student Department:");
          sdept=sc.next();
          System.out.println("Enter Student Program:");
          sprogram=sc.next();
          System.out.println("Enter Student CGPA:");
          scgpa=sc.nextDouble();
          System.out.println("Enter Student Email Address:");
          semail=sc.next();
          
          
          pstmt.setInt(1, sid);
          pstmt.setString(2,sname);
          pstmt.setString(3, sgender);
          pstmt.setString(4, sdept);
          pstmt.setString(5, sprogram);
          pstmt.setDouble(6, scgpa);
          pstmt.setString(7, semail);
          
          int result = pstmt.executeUpdate();
          
          if(result>0)
          {
            System.out.println("Record Inserted Successfully");
          }
          else
          {
            System.out.println("Failed to Insert Record");
          }
         
          
        }
        System.out.println("End of Insert Operation");
        
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
          int sid = 0;
          String sname=null,sgender =null;
          Double scgpa=0.0;
          System.out.println("Enter Details below to Update");
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter Student ID");
          sid = sc.nextInt();
          System.out.println("Enter Student Name");
          sname = sc.next();
          System.out.println("Enter Student Gender");
          sgender = sc.next();
          System.out.println("Enter Student CGPA");
          scgpa = sc.nextDouble();
          PreparedStatement pstmt = con.prepareStatement(" update student set sname=?,sgender=?,scgpa=? where sid=? ");
          
          pstmt.setString(1, sname);
          pstmt.setString(2, sgender);
          pstmt.setDouble(3, scgpa);
          pstmt.setInt(4, sid);
    int result = pstmt.executeUpdate();
    if(result>0)
    {
      System.out.println("Record Update Successfully");
    }
    else
    {
    	System.out.println("Failed to Update the Record");
    }
    pstmt.close();
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
      PreparedStatement pstmt = con.prepareStatement("select *from student");
      ResultSet rs = pstmt.executeQuery();
      System.out.println("sid "+"\t"+" sname " +"\t"+"sgender" +"\t"+"sdept" +"\t"+"sprogram"+"\t"+"scgpa"+"\t"+"semail");
          System.out.println("---------------------------------------------------------------------");
      while(rs.next())
      {
        System.out.println(rs.getInt(1)+"\t"+
        rs.getString(2)+"\t"+
        rs.getString("sgender")+"\t"+
        rs.getString(4)+"\t"+
        rs.getString("sprogram")+"\t"+
        rs.getDouble(6)+"\t"+
        rs.getString("semail")+"\t");
      }
      pstmt.close();
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
          int id = 0;
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter Student ID");
          id = sc.nextInt();
          PreparedStatement pstmt = con.prepareStatement("select *from student where sid=?");
          pstmt.setInt(1,id);
          ResultSet rs = pstmt.executeQuery();
          if(rs.next())
          {
            System.out.println("Student ID is present in the Database");
            PreparedStatement pstmt1 = con.prepareStatement("delete from student where sid=?");
            pstmt1.setInt(1, id);
            int result = pstmt1.executeUpdate();
            if(result>0)
            {
              System.out.println("Record Deleted Successfully");
            }
            
            else
            {
              System.out.println("Deletion Operation Failed!!");
            }
            pstmt1.close();
          }
          else
          {
            System.out.println("Record Not Found in Database");
          }
          pstmt.close();
          con.close();
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
      PreparedStatement pstmt = con.prepareStatement("select count(*) from student ");
      //PreparedStatement pstmt = con.prepareStatement("select count(*) as total from student ");
      ResultSet rs = pstmt.executeQuery();
      int count = 0;
      if(rs.next())
      {
         count = rs.getInt(1);
         //count = rs.getInt("total");
      }
      System.out.println("Number of records are "+count);
      pstmt.close();
      con.close();
      
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
  }
    