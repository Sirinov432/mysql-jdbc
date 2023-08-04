package az.company.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   private static Connection connection=null;
     public static Connection getConnection1(){

         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
         }

         try {
         connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_jdbc","root","root");
             System.out.println("connection has succesfully");
         } catch (SQLException e) {
             throw new RuntimeException(e);
         } return connection;
     }
     public static void closeConnection(){
         try {
             connection.close();
             System.out.println("connection ended");
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }
}
