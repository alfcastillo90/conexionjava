/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
                String sql = "INSERT INTO users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, "alfcastillo90");
                statement.setString(2, "secretpass");
                statement.setString(3, "Carlos Alfredo Castillo Rodriguez");
                statement.setString(4, "cacr1990@gmail.com");

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Registro exitoso!");
                }
            }
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
