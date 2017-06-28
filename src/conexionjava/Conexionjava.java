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
                //con esto podemos hacer un registro en la tabla users.
                String insertSql = "INSERT INTO users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
                //preparamos el query
                PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                //llenamos los campos
                insertStatement.setString(1, "erar3");
                insertStatement.setString(2, "secretpass");
                insertStatement.setString(3, "Emmanuel Aguilar");
                insertStatement.setString(4, "emmanuelrar@gmail.com");
                int rowsInserted = insertStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Registro exitoso!");
                }
                //con estos metodos podemos realizar una consulta
                String sql = "SELECT * FROM users";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                int count = 0;
                
                while(result.next()){
                    String name = result.getString(2);
                    String pass = result.getString(1);
                    String fullname = result.getString("fullname");
                    String email = result.getString("email");
                    String output = "User #%d: %s - %s - %s - %s";
                    System.out.println(String.format(output,++count,name,pass,fullname,email));
                }
                //con estos metodos modificamos una consulta
                String updateSql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
                PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                updateStatement.setString(1, "123456789");
                updateStatement.setString(2, "Carlos Castillo");
                updateStatement.setString(3, "alfcastillo90@outlook.com");
                updateStatement.setString(4, "alfcastillo90");
                int rowsUpdated = updateStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Actualizacion exitosa");
                }
                //con estos metodos podemos borrar un registro
                String deleteSql = "DELETE FROM Users WHERE username=?";
                PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                deleteStatement.setString(1, "erar2");
                int rowsDeleted = deleteStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("registro eliminado!");
                }
            }
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
