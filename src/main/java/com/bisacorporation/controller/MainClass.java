/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisacorporation.controller;

import BasicView.ReporteRegistraduria1Controller;
import BasicView.util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author JHON
 */
@ManagedBean( name = "main")
public class MainClass {
    
    private JasperReport repo;
    private JasperPrint repoFill;
    private JasperViewer viewer;
    
    public ReporteRegistraduria1Controller reporte1;

    public void generarReporte(String path){
    Conexion conexion;
    Connection con = null;
        try {
            conexion = new Conexion();
            con = conexion.conectar();
            String consulta = "select * from CALIDAD.REPORTE_REGISTRADURIA1 WHERE ROWNUM < 10";
            if(con.createStatement().execute(consulta)){
                System.out.println("Entro a cargar la consulta");
                 Statement statement =con.createStatement();
                 ResultSet resultSet=statement.executeQuery(consulta);
                  if (resultSet.next()) {
                      System.out.println("Print:"+ resultSet.toString());
                  }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        //NO SE CARGAN LOS DATOS CON LA CONEXION, PROBAR CON JPA O ALTERANDO LA CONEXION
        try {
            repo = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\JHON\\JaspersoftWorkspace\\reportes\\reporte1.jasper");
            //System.out.println("repo:" + repo.toString());
            repoFill = JasperFillManager.fillReport(repo, null, con);
        } catch (JRException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verReporte(){
        generarReporte("");
        //viewer = new JasperViewer(repoFill);
        //viewer.setVisible(Boolean.TRUE);
    }
    
    public void exportarAPDF(String destino){
        try {
            JasperExportManager.exportReportToPdfFile(repoFill, "C:\\report\\report1.pdf" );
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
