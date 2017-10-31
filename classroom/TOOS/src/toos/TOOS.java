/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class TOOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        try {
            //create an output stream for the file
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"));
            
            output.writeUTF("fernando martinez osorio m");
            output.writeDouble(73.3);
            output.writeObject(new Date());
            
            output.close();
                    }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "there is an error"+ ex.getMessage());
        }
                catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "there is an error"+ ex.getMessage());
        }
        
        
        
        
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"));
            String name = input.readUTF();
            double weight = input.readDouble();
            input.readDouble();
            Date date = (Date) input.readObject();
            
            System.out.println("name"+name+"wight"+ weight + "date" + date);
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "there is an error"+ ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "there is an error"+ ex.getMessage());
        }
    }
    
}
