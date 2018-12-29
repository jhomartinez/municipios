/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisacorporation.controller;

import BasicView.EmiErrormigracionController;
import BasicView.LmrLogmigracionregtipoController;
import BasicView.MrtMigracionregtipoController;
import com.bisacorporation.entities.EmiErrormigracion;
import com.bisacorporation.entities.LmrLogmigracionregtipo;
import com.bisacorporation.entities.MrtMigracionregtipo;
import com.github.rkumsher.date.DateUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author JHON
 */

public class Migracion {

    public BarChartModel barModel;
    
    private LmrLogmigracionregtipoController lmrLogmigracionregtipo;
    private MrtMigracionregtipoController mrtMigracionregtipo;
    private EmiErrormigracionController emiErrormigracion;
    
    LmrLogmigracionregtipo estadisticasHoy;
    List<MrtMigracionregtipo> listaRegtipoHoy;
    List<EmiErrormigracion> listaErrordetalleHoy;
    
    Date dateHoystart,dateHoyEnd;
    
    @PostConstruct
    public void init() {
        createBarModel();
    }
    
    public Migracion() {
        obtenerfechaActual();
        //Iniciar entidades
        mrtMigracionregtipo = new MrtMigracionregtipoController();
        lmrLogmigracionregtipo = new LmrLogmigracionregtipoController();
        emiErrormigracion = new EmiErrormigracionController();
        
        verReporteHoy();
    }
    
    public void obtenerfechaActual(){
        LocalDate localDate1 = LocalDate.of(2018,12,26);
        dateHoystart = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDate localDate2 = LocalDate.of(2018,12,27);
        dateHoyEnd = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * Obtiene la información de los reportes del día en general, asi hayan más de 1 migración.
     * Suma los datos y los presenta en la gráfica
     */
    public void verReporteHoy(){
        estadisticasHoy = lmrLogmigracionregtipo.contarMigDeHoy(getDateHoystart(), getDateHoyEnd());
        if(estadisticasHoy != null){
            System.out.println("Insert:"+estadisticasHoy.getLmrInsertados());
            System.out.println("Actualizados"+estadisticasHoy.getLmrActualizados());
            System.out.println("Errores:"+estadisticasHoy.getLmrErrores());
            System.out.println("Borrados"+estadisticasHoy.getLmrBorrados());
        } else {
            System.out.println("La entidad x esta vacia");
        }
    }
    public void verReporteHoyDetallado(Date d1, Date d2){
        
    }
    public BigInteger obtenerMaxGraficaBarras1(){
    BigInteger mayor = new BigInteger("0");
    if(mayor.compareTo(estadisticasHoy.getLmrInsertados())<0)
        mayor = estadisticasHoy.getLmrInsertados();
    if(mayor.compareTo(estadisticasHoy.getLmrActualizados())<0)
        mayor = estadisticasHoy.getLmrActualizados();
    if(mayor.compareTo(estadisticasHoy.getLmrBorrados())<0)
        mayor = estadisticasHoy.getLmrBorrados();
    if(mayor.compareTo(estadisticasHoy.getLmrErrores())<0)
        mayor = estadisticasHoy.getLmrErrores();
    System.out.println("mayor:"+mayor.toString());
    return mayor;
    }
    
    private void createBarModel() {
        barModel = initBarModel();
        barModel.setLegendPosition("ne");
 
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Procesos");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Registros");
        yAxis.setMin(0);
        yAxis.setMax(obtenerMaxGraficaBarras1());
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        model.setBarWidth(50);
        model.setBarMargin(50);
        
        ChartSeries insert = new ChartSeries();
        insert.setLabel("Insertados "+ estadisticasHoy.getLmrInsertados().toString());
        insert.set(estadisticasHoy.getLmrInsertados().toString(), estadisticasHoy.getLmrInsertados());

        ChartSeries update = new ChartSeries();
        update.setLabel("Actualizados "+ estadisticasHoy.getLmrActualizados().toString());
        update.set(estadisticasHoy.getLmrActualizados().toString(), estadisticasHoy.getLmrActualizados());
        
        ChartSeries delete = new ChartSeries();
        delete.setLabel("Borrados "+ estadisticasHoy.getLmrBorrados().toString());
        delete.set(estadisticasHoy.getLmrBorrados().toString(), estadisticasHoy.getLmrBorrados());

        ChartSeries error = new ChartSeries();
        error.setLabel("Errores "+ estadisticasHoy.getLmrErrores().toString());
        error.set(estadisticasHoy.getLmrErrores().toString(), estadisticasHoy.getLmrErrores());

        model.addSeries(insert);
        model.addSeries(update);
        model.addSeries(delete);
        model.addSeries(error);

        return model;
    }
    
    
    
    
    //GETTERS AND SETTERS
    
    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    
    public List<MrtMigracionregtipo> getListaRegtipoHoy() {
        if(listaRegtipoHoy == null){
            listaRegtipoHoy = mrtMigracionregtipo.obtenerRegTipoDeHoy(getDateHoystart(), getDateHoyEnd());
        }
        return listaRegtipoHoy;
    }

    public void setListaRegtipoHoy(List<MrtMigracionregtipo> listaRegtipoHoy) {
        this.listaRegtipoHoy = listaRegtipoHoy;
    }
    
    public List<EmiErrormigracion> getListaErrordetalleHoy() {
        if(listaErrordetalleHoy == null){
            //listaErrordetalleHoy = emiErrormigracion.obtenerErroresDeHoy(getDateHoystart(), getDateHoyEnd());
        }
        return listaErrordetalleHoy;
    }

    public void setListaErrordetalleHoy(List<EmiErrormigracion> listaErrordetalleHoy) {
        this.listaErrordetalleHoy = listaErrordetalleHoy;
    }
    
    public Date getDateHoystart() {
        return dateHoystart;
    }

    public void setDateHoystart(Date dateHoystart) {
        this.dateHoystart = dateHoystart;
    }

    public Date getDateHoyEnd() {
        return dateHoyEnd;
    }

    public void setDateHoyEnd(Date dateHoyEnd) {
        this.dateHoyEnd = dateHoyEnd;
    }
}
