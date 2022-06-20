package demo;
import java.io.*;
import java.sql.*;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/dbconnection")
public class MYSQLDBCOnnectionServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      out.print("Servlet prohram for data base connection");
      try
      {
    	  Connection con=null;
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  out.println("Driverclass loaded");
    	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/epjdbc?useSSL=false","root","Sailu@123");
    	  out.println("connection established sucessfully");
    	  
    	  
      }
      catch(Exception e)
      {
    	  out.println(e);
      }
  }
}