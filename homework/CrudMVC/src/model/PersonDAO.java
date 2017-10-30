/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class PersonDAO
{
    Conexion conexion;
    
    public PersonDAO()
    {
        conexion = new Conexion();
    }
    
    public ArrayList<Person> listPerson()
            {
                ArrayList listPerson = new ArrayList();
                Person person = new Person();
                
                try 
                {
                    Connection DbAccess = conexion.getConnection();
                    PreparedStatement ps = DbAccess.prepareStatement("select * from person");
                    ResultSet rs = ps.executeQuery();
                    
                    while(rs.next())
                    {
                        person = new Person();
                        person.setDni(rs.getString(1));
                        person.setLastName(rs.getString(2));
                        person.setName(rs.getString(3));
                        person.setBirthday(rs.getString(4));
                        person.setPlace(rs.getString(5));
                        listPerson.add(person);
                    }
                } 
                
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null, "error" + e.getMessage());
                }
                return listPerson;
            }//end listPerson
    
    public String insertPerson( String lastName, String name, String birthday, String place)
    {
        String queryResult = null;
        
        try 
        {
            Connection DbAccess = conexion.getConnection();
            PreparedStatement ps = DbAccess.prepareStatement("insert into person (lastName, name, birthday, place) values(?,?,?,?)");
            ps.setString(1, lastName);
            ps.setString(2, name);
            ps.setString(3, birthday);
            ps.setString(4, place);
            
            int numAffectedRows = ps.executeUpdate();
            
            
            if(numAffectedRows >0)
                    {
                        queryResult ="registro exitoso";
                    }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        return queryResult;
    }
    public String UpdatePerson(String lastName, String name, String birthday, String place,String dni)
    {
        String queryResult = null;
        
        try 
        {
            Connection DbAccess = conexion.getConnection();
            PreparedStatement ps = DbAccess.prepareStatement ("UPDATE person set lastName" + "='" + lastName+
            "', name= '" + name +  "',birthday= '" + birthday+  "', place= '"+ place+ "' WHERE dni= "+ dni+" ");
            
            int numAffectedRows = ps.executeUpdate();
            
            
            if(numAffectedRows >0)
                    {
                        queryResult ="registro actualizado";
                    }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        return queryResult;
    }
    
    public String DeletePerson(String dni)
    {
        String queryResult = null;
        
        try 
        {
            Connection DbAccess = conexion.getConnection();
            PreparedStatement ps = DbAccess.prepareStatement ("DELETE from person WHERE dni= "+ dni+" ");

            
            int numAffectedRows = ps.executeUpdate();
            
            
            if(numAffectedRows >0)
                    {
                        queryResult ="dato borrado";
                    }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        return queryResult;
    }
    
    public ArrayList<Person> searchPerson(String dni)
            {
                ArrayList searchPerson = new ArrayList();
                Person person;
                
                try 
                {
                    Connection DbAccess = conexion.getConnection();
                    PreparedStatement ps = DbAccess.prepareStatement("SELECT * FROM person WHERE dni LIKE '%" + dni + "%'");
                    ResultSet rs = ps.executeQuery();
                    
                    while(rs.next())
                    {
                        person = new Person();
                        person.setDni(rs.getString(1));
                        person.setLastName(rs.getString(2));
                         person.setName(rs.getString(3));
                        person.setBirthday(rs.getString(4));
                        person.setPlace(rs.getString(5));
                        searchPerson.add(person);
                    }
                } 
                
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null, "error" + e.getMessage());
                }
                return searchPerson;
            }
    
}
