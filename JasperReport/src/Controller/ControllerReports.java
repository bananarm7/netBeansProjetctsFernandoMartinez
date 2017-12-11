/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import Model.*;


/**
 *
 * @author ferna
 */
public class ControllerReports {
    
    public void executeReport(){
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/Reports/MyReport1.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex.getMessage());
        }
    }
    public void executeReportWithParameters(String title){
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/Reports/MyReport1.jasper"));
            Map parameters = new HashMap<String , Object>();
            parameters.put("title", title);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "JRException" +ex.getMessage());
        }
    }
    public void executeReportWithSql(){
        Connection con = new Connection();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/Reports/MyReportWithAparent.jasper"));
             JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConexion());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex.getMessage());
        }
    }
    public void executeBarChartReport(){
        Connection con = new Connection();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/Reports/BarChartReport.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConexion());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERROR JRException" + ex.getMessage() );
        }
    }
    
}
