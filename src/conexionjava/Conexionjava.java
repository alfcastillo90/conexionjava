/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alfredo
 */
public class Conexionjava {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String dbURL = "jdbc:mysql://localhost:3306/javausers";
        String username ="root";
        String password = "";
        
        try{
            Connection conn = DriverManager.getConnection(dbURL,username,password);
            if(conn!=null){
                System.out.println("Connected");
            }
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
