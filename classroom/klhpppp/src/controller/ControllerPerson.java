/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.PersonDao;

/**
 *
 * @author Juan
 */
public class ControllerPerson {

    PersonDao model = new PersonDao();

    public void fillTalble(JTable table) {
        DefaultTableModel modelTable = new DefaultTableModel();

        table.setModel(modelTable);//Obtiene los datos de la tabla

        modelTable.addColumn("DNI");//Agrega el nombre a las cabezeras
        modelTable.addColumn("LAST NAME");
        modelTable.addColumn("NAME");
        modelTable.addColumn("BIRTHDAY");
        modelTable.addColumn("PLACE");

        Object[] column = new Object[5];
        int numRows = model.listPerson().size();

        for (int i = 0; i < numRows; i++) {
            column[0] = model.listPerson().get(i).getDni();//Agrega dni al array columna[0]
            column[1] = model.listPerson().get(i).getLastName();//Agrega lastName al array columna[0]
            column[2] = model.listPerson().get(i).getName();//Agrega name al array columna[0]
            column[3] = model.listPerson().get(i).getDate();//Agrega date al array columna[0]
            column[4] = model.listPerson().get(i).getPlace();//Agrega place al array columna[0]
            modelTable.addRow(column);
        }
    }//end fillTable

    public void insertPerson(String lastName, String name, String date, String place) {
        String messageResult = model.insertPerson(lastName, name, date, place);//guarda los datos en la bd
        if (messageResult != null) {//si los messageResul no es nulo ejecuta el mensaje
            JOptionPane.showMessageDialog(null, messageResult);
        } else {
            JOptionPane.showMessageDialog(null, "Registro erroneo!");//de lo contrario ejecuta este mensaje
        }//end insertPerson
    }

    public void updatePerson(String dni, String lastName, String name, String date, String place) {
        String messageResult = model.updatPerson(dni, lastName, name, date, place);
        if (messageResult != null) {
            JOptionPane.showMessageDialog(null, messageResult);
        } else {
            JOptionPane.showMessageDialog(null, "Actualizacion Erronea!");//de lo contrario ejecuta este mensaje
        }
    }//end updatePerson

    public void deletePerson(String dni) {
        String messageResult = model.deletePerson(dni);
        if (messageResult != null) {
            JOptionPane.showMessageDialog(null, messageResult);
        } else {
            JOptionPane.showMessageDialog(null, "Dato Eliminado!");
        }
    }//end deletePerson

    public void searchPerson(JTable table, String dni) {
        DefaultTableModel modelTable = new DefaultTableModel();

        table.setModel(modelTable);//Obtiene los datos de la tabla

        modelTable.addColumn("DNI");//Agrega el nombre a las cabezeras
        modelTable.addColumn("LAST NAME");
        modelTable.addColumn("NAME");
        modelTable.addColumn("BIRTHDAY");
        modelTable.addColumn("PLACE");

        Object[] column = new Object[5];
        int numRows = model.searchPerson(dni).size();

        for (int i = 0; i < numRows; i++) {
            column[0] = model.searchPerson(dni).get(i).getDni();//Agrega dni al array columna[0]
            column[1] = model.searchPerson(dni).get(i).getLastName();//Agrega lastName al array columna[0]
            column[2] = model.searchPerson(dni).get(i).getName();//Agrega name al array columna[0]
            column[3] = model.searchPerson(dni).get(i).getDate();//Agrega date al array columna[0]
            column[4] = model.searchPerson(dni).get(i).getPlace();//Agrega place al array columna[0]
            modelTable.addRow(column);
        }
    }
}
