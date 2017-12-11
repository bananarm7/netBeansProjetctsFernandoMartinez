/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class PersonDao {

    Conexion conexion;

    public PersonDao() {
        conexion = new Conexion();
    }

    public ArrayList<Person> listPerson() {
        ArrayList listPerson = new ArrayList();
        Person person;
        try {
            Connection DbAccess = conexion.getConnection();
            PreparedStatement ps = DbAccess.prepareStatement("SELECT * FROM person");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                person = new Person();//declaro objeto persona
                person.setDni(rs.getString(1));//se estables dni
                person.setLastName(rs.getString(2));
                person.setName(rs.getString(3));
                person.setDate(rs.getString(4));
                person.setPlace(rs.getString(5));
                listPerson.add(person);//se establese persona al array de listPerson
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return listPerson;
    }

    //end listPerson
    public String insertPerson(String LastName, String name, String date, String place) {
        String queryResult = null;
        try {
            Connection DbAccess = conexion.getConnection();
            PreparedStatement ps = DbAccess.prepareStatement("INSERT INTO person "
                    + "(lastName, name, birthDay, place) values (?,?,?,?)");
            ps.setString(1, LastName);
            ps.setString(2, name);
            ps.setString(3, date);
            ps.setString(4, place);

            int numAffectedRows = ps.executeUpdate();

            if (numAffectedRows > 0) {
                queryResult = "Registro Exitoso!";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return queryResult;
    }//end insertperson

    public String updatPerson(String dni, String LastName, String name, String date, String place) {
        String queryResult = null;

        try {
            Connection DbAccess = conexion.getConnection();
            PreparedStatement ps = DbAccess.prepareStatement("UPDATE person set lastName"
                    + " = '" + LastName + "', name= '" + name + "', birthDay='" + date + "',"
                    + " place = '" + place + "' WHERE dni =" + dni + " ");

            int numAffectedRows = ps.executeUpdate();

            if (numAffectedRows > 0) {
                queryResult = "Actualizacion Exitosa!";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return queryResult;
    }//end updatePerson

    public String deletePerson(String dni) {
        String queryResult = null;

        try {
            Connection DbAccess = conexion.getConnection();
            PreparedStatement ps = DbAccess.prepareStatement("DELETE FROM person WHERE dni =" + dni + "");

            int numAffectedRows = ps.executeUpdate();

            if (numAffectedRows > 0) {
                queryResult = "Dato Eliminado!";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return queryResult;
    }//end detelePerson

//    public void searchPerson(String dni) throws SQLException {
//        Connection DbAccess = conexion.getConnection();
//        PreparedStatement ps = DbAccess.prepareStatement("SELECT lastName, name, birthDay, place FROM person WHERE dni LIKE '%" + dni + "%'");
//
//    }
// 
    public ArrayList<Person> searchPerson(String dni) {
        ArrayList searchPerson = new ArrayList();
        Person person;
        try {
            Connection DbAccess = conexion.getConnection();
            PreparedStatement ps = DbAccess.prepareStatement("SELECT dni, lastName, name, birthDay, place FROM person WHERE dni LIKE '%" + dni + "%'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                person = new Person();//declaro objeto persona
                person.setDni(rs.getString(1));//se estables dni
                person.setLastName(rs.getString(2));
                person.setName(rs.getString(3));
                person.setDate(rs.getString(4));
                person.setPlace(rs.getString(5));
                searchPerson.add(person);//se establese persona al array de listPerson
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return searchPerson;
    }

}
