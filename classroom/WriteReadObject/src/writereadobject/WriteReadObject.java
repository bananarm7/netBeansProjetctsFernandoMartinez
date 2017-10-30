
package writereadobject;
import java.io.*;
import javax.swing.JOptionPane;
public class WriteReadObject {

    public static void main(String[] args) {
      //writes an object to a binary file
      ObjectOutputStream fileOut;//objeto de tipo salida
      TestObject obj = new TestObject(1, "test1", 2.0);//ingresar valores al objeto por medio de la clase TestObject
      String fileName=JOptionPane.showInputDialog(null, "enter the file's name");//ingresar el nombre del archivo
      
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(fileName));// new FileOutStream crea un objeto de tipo salida
//fileOut = new ObjectOutputStream= Abre el flujo de archivo
            fileOut.writeObject(obj);
            fileOut.close();//cierra el flujo del objeto
            
        } catch (FileNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "file not found"+ex.getMessage()); //no se encuentra el archivo
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException"+ex.getMessage()); //no se puede crear
        }
        //read object from a binary file
        TestObject objIn;
        
        try {
            ObjectInputStream fileInt= new ObjectInputStream(new FileInputStream(fileName));
             objIn= (TestObject) fileInt.readObject();
             objIn.display();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "file not found"+ex.getMessage());//captura si el archivo no extiste
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException"+ex.getMessage());//error en la lectura del archivo
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "class not found"+ex.getMessage());
        }
        
    }
    
}
