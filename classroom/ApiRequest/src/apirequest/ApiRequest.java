
package apirequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import javax.swing.JOptionPane;


/*@author ferna*/

public class ApiRequest {

    public static void main(String[] args) throws IOException, org.json.simple.parser.ParseException {
        try {
            URL url = new URL("https://api.darksky.net/forecast/933d99ea7611eb56677cd17aea031c30/23.2494,-106.4111");
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();//cast en (HttpURLConnection) url.openConnection()
            conn.setRequestMethod("GET");//metodo para request de datos al servidor
            conn.setRequestProperty("Accept", "application/json");
            
            
            if (conn.getResponseCode()!=200) { //si el codigo de respuesta es 200 esta bien, si no hubo error
                throw new RuntimeException("failed: HTTP error code"
                + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //se obtiene el resultado de la conexion, se crea en un InputStreamReader y se almacena en br
            String output="";
            String JSONData="";
            JSONParser parser = new JSONParser();
            while ((output = br.readLine()) != null) //recorrer ressultado 
            {
//                System.out.println(output);
                    JSONData+= output;
            }
            Object object =parser.parse(JSONData);
            JSONObject jObject=(JSONObject)object;
            double latitude= (double)jObject.get("latitude");
            double longitude= (double)jObject.get("longitude");
            String timeZone=(String)jObject.get("timezone");
            System.out.println(latitude);
            System.out.println(longitude);
            System.out.println(timeZone);
            
            JSONObject c=(JSONObject)object;
            JSONObject cur =(JSONObject)c.get("currently");
            String summary =(String)cur.get("summary");
            String icon =(String)cur.get("icon");
            
            System.out.println(summary);
            System.out.println(icon);
            
            
        } 
        
        
        catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null,"not found"+ ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"not found"+ ex.getMessage());
        }
        
    }
    
}
