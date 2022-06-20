package demo;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/servletone")
public class ServletOne extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      ServletConfig sconfig=getServletConfig();
      ServletContext scontext=getServletContext();
      
      out.print(sconfig.getInitParameter("uname"));
      out.println(sconfig.getInitParameter("pwd"));
      
      out.print(scontext.getInitParameter("id"));
      out.print(scontext.getInitParameter("name"));
      
  }
}