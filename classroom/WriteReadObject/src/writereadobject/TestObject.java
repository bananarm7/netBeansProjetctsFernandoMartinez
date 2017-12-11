
package writereadobject;
import java.io.Serializable;

public class TestObject implements Serializable {
    private int id;
    private String text;
    public double number;
    
    public TestObject(int id, String text, double number){
     this.id=id;   
     this.text=text;   
     this.number=number;   
    }
    public void display(){
        System.out.println(this.id);
        System.out.println(this.text);
        System.out.println(this.number);
    }
}
