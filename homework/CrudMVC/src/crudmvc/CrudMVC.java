/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import view.JFPerson;
/**
 *
 * @author ferna
 */
public class CrudMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JFPerson view = new JFPerson();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        
    }
    
}
