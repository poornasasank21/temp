 
package crudoperations;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import demo.DBConnection;

@WebServlet("/viewusers")
public class ViewUsersServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
      //out.println("I am in view users servlet");
      try
      {
    	  Connection con = null;
    	  Class.forName("com.mysql.cj.jdbc.Driver");
          
          
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/epjdbc?allowPublicKeyRetrieval=true&useSSL=False","root", "Sailu@123");
      
        
        ResultSet rs = con.createStatement().executeQuery("select * from userregistration ");
        
        
        out.println("<h3>List of Registered Users</h3>");
        out.println("<table align=center border=1>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Full Name</th>");
        out.println("<th>Gender</th>");
        out.println("<th>DOB</th>");
        out.println("<th>Email</th>");
        out.println("<th>Username</th>");
        out.println("<th>Mobile No.</th>");
        out.println("<th>Location</th>");
        
        out.println("</tr>");
       
        while(rs.next())
        {
          out.println("<tr>");
          out.println("<td>"+rs.getString(1)+"</td>");
          out.println("<td>"+rs.getString(2)+"</td>");
          out.println("<td>"+rs.getString(3)+"</td>");
          out.println("<td>"+rs.getString(4)+"</td>");
          out.println("<td>"+rs.getString(5)+"</td>");
          out.println("<td>"+rs.getString(6)+"</td>");
          out.println("<td>"+rs.getString(8)+"</td>");
          out.println("<td>"+rs.getString(9)+"</td>");
    
          out.println("</tr>");
        }
        out.println("</table>");
        
      }
      catch(Exception e )
      {
        out.println(e);
      }
  }
}