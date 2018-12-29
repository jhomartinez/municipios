/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisacorporation.controller;

import com.itextpdf.text.pdf.PdfName;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author JHON
 */
@ManagedBean(name="chartView")
@SessionScoped
public class ChartView implements Serializable {

    private BarChartModel barModel;
    private PieChartModel pieModel1;
   
    @PostConstruct
    public void init() {
        createBarModels();
        createPieModels();
    }

    public void itemSelectBar(ItemSelectEvent event) {
        String title = "INFORMACIÓN";
        String nombreBar = "";
        int valorBar = 0;
        if(event.getSeriesIndex() == 1 ){
            nombreBar = " Registros cruzados con Registraduria Nacional";
            valorBar = 27189;
            cargarDatosRegistraduria();
        } else if (event.getSeriesIndex() == 0 ) {
            nombreBar = " Registros en Calidad";
            valorBar = 25473;
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, title,
                 valorBar + nombreBar);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void itemSelectPie(ItemSelectEvent event) {
        String title = "INFORMACIÓN";
        String nombreBar = "";
        switch(event.getSeriesIndex()){
            case 0:
                nombreBar = " calificación del 100%";
                break;
            case 1:
                nombreBar = " calificación de 90-99%";
                break;
            case 2:
                nombreBar = " calificación de 80-89%";
                break;
            case 3:
                nombreBar = " calificación de 70-79%";
                break;
            case 4:
                nombreBar = " calificación de 60-69%";
                break;
            case 5:
                nombreBar = " calificación de 50-59%";
                break;
            case 6:
                nombreBar = " calificación menor a 50%";
                break;
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    private void cargarDatosRegistraduria() {
        
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        model.setBarWidth(30);
        model.setBarMargin(50);

        ChartSeries rn = new ChartSeries();
        rn.setLabel("Cruce con RN");
        rn.set("07/12/18 03:00:28 AM", 25473);

        ChartSeries calidad = new ChartSeries();
        calidad.setLabel("Carga en Calidad");
        calidad.set("07/12/18 03:01:16 AM", 27189);

        model.addSeries(rn);
        model.addSeries(calidad);

        return model;
    }
    

    private void createBarModels() {
        createBarModel();
    }
    
    private void createPieModels() {
        createPieModel1();
    }
    
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
 
        pieModel1.set("100", 5177);
        pieModel1.set("90-99", 5102);
        pieModel1.set("80-89", 12444);
        pieModel1.set("70-79", 137);
        pieModel1.set("60-69", 221);
        pieModel1.set("50-59", 336);
        pieModel1.set("<49", 2056);
 
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(true);
    }
    
    private void createBarModel() {
        barModel = initBarModel();
 
        barModel.setTitle("Comparación entre carga en Calidad y cruce de registros con RN");
        barModel.setLegendPosition("ne");
 
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Tablas");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Registros");
        yAxis.setMin(0);
        yAxis.setMax(30000);
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }
    
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
    
    public void buttonGlobal() {
        addMessage("Cargando información Global");
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            externalContext.redirect("/views/estad_Generales.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.WARNING, null, ex);
        }
    }
    
    public void buttonHoy() {
        addMessage("Cargando información de hoy");
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            externalContext.redirect("/views/estad_Hoy.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.WARNING, null, ex);
        }
    }
 
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
