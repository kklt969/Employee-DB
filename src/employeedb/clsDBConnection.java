/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeedb;
import java.sql.*;
/**
 *
 * @author User
 */
public class clsDBConnection {
    
    public static Connection getConnection()
    {
        Connection con = null;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb?user=root&password=8834");
        
        System.out.println("The connection with mysql is succesful");
        
        
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
        catch(SQLException e)
        {
           e.printStackTrace();
           System.out.println(e);
        }   
        return con;
    }

        
    
    
}
