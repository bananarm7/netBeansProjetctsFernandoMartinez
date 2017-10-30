/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.PersonDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ferna
 */
public class ControllerPerson 
{
    PersonDAO model = new PersonDAO();
    
    
    public void fillTable(JTable table)
    {
        DefaultTableModel modelTable = new DefaultTableModel();
              
        table.setModel(modelTable);
        modelTable.addColumn("DNI");
        modelTable.addColumn("LASTNAME");
        modelTable.addColumn("NAME");
        modelTable.addColumn("BIRTHDAY");
        modelTable.addColumn("PLACE");
        
        Object[] column = new Object[5];//se crea  el obejto column, que va a recorrer
        int numRows = model.listPerson().size();
        
        for (int i = 0; i < numRows; i++) 
        {
            column [0] = model.listPerson().get(i).getDni();
            column [1] = model.listPerson().get(i).getLastName();
            column [2] = model.listPerson().get(i).getName();
            column [3] = model.listPerson().get(i).getBirthday();
            column [4] = model.listPerson().get(i).getPlace();
            modelTable.addRow(column); 
        }
    } //end fillTable, se rellena el modelo de la vista
    public void insertPerson(String lastName, String name, String birthday, String place)//metodo que insertara los datos de la vista
    {
        String messageResult= model.insertPerson(lastName, name, birthday, place); //messageResult guardara los datos del modelo, que son de tipo string, y mostrara un mensaje de exito
        
        if (messageResult != null) //si el msresult no esta vacio se imprime en joption
        {
           JOptionPane.showMessageDialog(null, messageResult);//null muestra el mensaje en el centro del JOptionpane
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "registro erroneo, try again");
        }
    }
        public void updatePerson(String dni, String lastName, String name, String birthday, String place)//metodo que insertara los datos de la vista
    {
        String messageResult= model.UpdatePerson(dni, lastName, name, birthday, place); //messageResult guardara los datos del modelo, que son de tipo string, y mostrara un mensaje de exito
        
        if (messageResult != null) //si el msresult no esta vacio se imprime en joption
        {
           JOptionPane.showMessageDialog(null, messageResult);//null muestra el mensaje en el centro del JOptionpane
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "registro erroneo, try again");
        }
    }
        
    public void DeletePerson(String dni)//metodo que eliminara los datos de la vista
    {
        String messageResult= model.DeletePerson(dni); //messageResult guardara los datos del modelo, que son de tipo string, y mostrara un mensaje de exito
        
        if (messageResult != null) //si el msresult no esta vacio se imprime en joption
        {
           JOptionPane.showMessageDialog(null, messageResult);//null muestra el mensaje en el centro del JOptionpane
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "registro erroneo, try again");
        }
    }
    
    
    public void searchPerson(JTable table, String dni)
    {
        DefaultTableModel modelTable = new DefaultTableModel();
              
        table.setModel(modelTable);
        
        modelTable.addColumn("DNI");
        modelTable.addColumn("LASTNAME");
        modelTable.addColumn("NAME");
        modelTable.addColumn("BIRTHDAY");
        modelTable.addColumn("PLACE");
        
        Object[] column = new Object[5];//se crea  el obejto column, que va a recorrer
        int numRows = model.searchPerson(dni).size();
        
        for (int i = 0; i < numRows; i++) 
        {
            column [0] = model.searchPerson(dni).get(i).getDni();
            column [1] = model.searchPerson(dni).get(i).getLastName();
            column [2] = model.searchPerson(dni).get(i).getName();
            column [3] = model.searchPerson(dni).get(i).getBirthday();
            column [4] = model.searchPerson(dni).get(i).getPlace();
            modelTable.addRow(column); 
        }
    }
}
