/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class Conexion {

    public Connection getConnection() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String serverDb = "jdbc:mysql://localhost:3306/mydb";
            String userDb = "root";
            String passwordDb = "";
            conexion = DriverManager.getConnection(serverDb, userDb, passwordDb);
        } 
        
        
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "The driver wasnt found");
        } 
        
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There was a problem" + e.getMessage());
        } 
        
        finally {
            return conexion;
        }
    }
}
