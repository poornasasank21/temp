 package demo;
import java.sql.*;


public class DBConnection {
  static Connection con = null;
  public static Connection getConnection() {
    try {
       Class.forName("com.mysql.cj.jdbc.Driver");
          
      
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/epjdbc?allowPublicKeyRetrieval=true&useSSL=False","root", "C1974omsairam@");
  
      return con;
    }
    catch (Exception e){
      System.out.println(e);
      return con;
    }
    
  }
  public static void main (String args[]) {
    DBConnection dbconnection = new DBConnection();
    dbconnection.getConnection();
  }
}