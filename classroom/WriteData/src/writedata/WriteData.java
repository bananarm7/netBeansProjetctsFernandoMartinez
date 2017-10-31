/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writedata;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ferna
 */
public class WriteData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File file = new File("scores.txt");
        if (file.exists()) 
        {
            System.out.println("file already exixt "); 
            System.exit(0);
        }
        PrintWriter output = new PrintWriter(file);
        output.print("john t ");
        output.println(90);
        output.print("erick j");
        output.println("85");
        output.close();
    }
    
}
