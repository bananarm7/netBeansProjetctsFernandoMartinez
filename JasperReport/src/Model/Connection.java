/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class Connection {
     public java.sql.Connection getConexion(){
       java.sql.Connection conexion = null;
       
       try{
           
           Class.forName("com.mysql.jdbc.Driver"). newInstance();
           String serverDb = "jdbc:mysql://localhost:3306/mydb";
           String userDb = "root";
           String passwordDb = "";
           conexion = DriverManager.getConnection(serverDb, userDb, passwordDb);
       }catch (ClassNotFoundException e){
          JOptionPane.showMessageDialog(null, "The Drinve was not Found");
          
       }catch (SQLException e){
           JOptionPane.showMessageDialog(null, "The was a problem");
       }finally{
           return conexion;
       }
    }

    
}
