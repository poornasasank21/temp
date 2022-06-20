package crudoperations;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

import demo.DBConnection;

@WebServlet("/userreg")
public class UserRegistrationServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      String fname=request.getParameter("fname");
      String gender=request.getParameter("gender");
      String dob=request.getParameter("dob");
      String email=request.getParameter("email");
      String uname=request.getParameter("uname");
      String pwd=request.getParameter("pwd");
      String mob=request.getParameter("mob");
      String loc=request.getParameter("loc");
      
      try
      {
    	   Connection con = null;
    	  Class.forName("com.mysql.cj.jdbc.Driver");
          
          
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/epjdbc?allowPublicKeyRetrieval=true&useSSL=False","root", "Sailu@123");
      
        
    PreparedStatement pstmt = con.prepareStatement(" insert into userregistration(fullname,gender,dateofbirth,email,username,password,mobileno,location) values(?,?,?,?,?,?,?,?); ");
       pstmt.setString(1,fname); 
       pstmt.setString(2,gender); 
       pstmt.setString(3,dob); 
       pstmt.setString(4,email); 
       pstmt.setString(5,uname); 
       pstmt.setString(6,pwd); 
       pstmt.setString(7,mob); 
       pstmt.setString(8,loc); 
     
       
       int n = pstmt.executeUpdate();
       con.close();
       
       if(n>0)
       {
         out.println("User Registration Successful");
       }
       else
       {
         out.println("Fail to Register");
       }
    
      }
      catch(Exception e)
      {
        out.println(e);
      }
      
  }
}