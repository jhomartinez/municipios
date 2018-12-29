/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisacorporation.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JHON
 */
@Entity
@Table(name = "REPORTE_REGISTRADURIA1", schema = "CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteRegistraduria1.findAll", query = "SELECT r FROM ReporteRegistraduria1 r"),
    @NamedQuery(name = "ReporteRegistraduria1.findByCalifiRegistraduria", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.califiRegistraduria = :califiRegistraduria"),
    @NamedQuery(name = "ReporteRegistraduria1.findByCalifiTipodocRegistraduria", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.califiTipodocRegistraduria = :califiTipodocRegistraduria"),
    @NamedQuery(name = "ReporteRegistraduria1.findByTipodocRegis", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.tipodocRegis = :tipodocRegis"),
    @NamedQuery(name = "ReporteRegistraduria1.findByPrimeApellidoRegis", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.primeApellidoRegis = :primeApellidoRegis"),
    @NamedQuery(name = "ReporteRegistraduria1.findBySegundoApellidoRegis", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.segundoApellidoRegis = :segundoApellidoRegis"),
    @NamedQuery(name = "ReporteRegistraduria1.findByPrimeNombreRegis", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.primeNombreRegis = :primeNombreRegis"),
    @NamedQuery(name = "ReporteRegistraduria1.findBySegundoNombreRegis", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.segundoNombreRegis = :segundoNombreRegis"),
    @NamedQuery(name = "ReporteRegistraduria1.findByTipodocInfrac", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.tipodocInfrac = :tipodocInfrac"),
    @NamedQuery(name = "ReporteRegistraduria1.findByApellido1Infrac", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.apellido1Infrac = :apellido1Infrac"),
    @NamedQuery(name = "ReporteRegistraduria1.findByApellido2Infrac", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.apellido2Infrac = :apellido2Infrac"),
    @NamedQuery(name = "ReporteRegistraduria1.findByNombre1Infrac", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.nombre1Infrac = :nombre1Infrac"),
    @NamedQuery(name = "ReporteRegistraduria1.findByNombre2Infrac", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.nombre2Infrac = :nombre2Infrac"),
    @NamedQuery(name = "ReporteRegistraduria1.findByDocumentoRegis", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.documentoRegis = :documentoRegis"),
    @NamedQuery(name = "ReporteRegistraduria1.findByFechaCarga", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.fechaCarga = :fechaCarga"),
    @NamedQuery(name = "ReporteRegistraduria1.findByIdRepoestadis1", query = "SELECT r FROM ReporteRegistraduria1 r WHERE r.idRepoestadis1 = :idRepoestadis1")})
public class ReporteRegistraduria1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 3)
    @Column(name = "CALIFI_REGISTRADURIA")
    private String califiRegistraduria;
    @Size(max = 3)
    @Column(name = "CALIFI_TIPODOC_REGISTRADURIA")
    private String califiTipodocRegistraduria;
    @Size(max = 3)
    @Column(name = "TIPODOC_REGIS")
    private String tipodocRegis;
    @Size(max = 50)
    @Column(name = "PRIME_APELLIDO_REGIS")
    private String primeApellidoRegis;
    @Size(max = 50)
    @Column(name = "SEGUNDO_APELLIDO_REGIS")
    private String segundoApellidoRegis;
    @Size(max = 50)
    @Column(name = "PRIME_NOMBRE_REGIS")
    private String primeNombreRegis;
    @Size(max = 50)
    @Column(name = "SEGUNDO_NOMBRE_REGIS")
    private String segundoNombreRegis;
    @Size(max = 3)
    @Column(name = "TIPODOC_INFRAC")
    private String tipodocInfrac;
    @Size(max = 50)
    @Column(name = "APELLIDO1_INFRAC")
    private String apellido1Infrac;
    @Size(max = 50)
    @Column(name = "APELLIDO2_INFRAC")
    private String apellido2Infrac;
    @Size(max = 50)
    @Column(name = "NOMBRE1_INFRAC")
    private String nombre1Infrac;
    @Size(max = 50)
    @Column(name = "NOMBRE2_INFRAC")
    private String nombre2Infrac;
    @Size(max = 50)
    @Column(name = "DOCUMENTO_REGIS")
    private String documentoRegis;
    @Column(name = "FECHA_CARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCarga;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPOESTADIS1")
    private BigDecimal idRepoestadis1;

    public ReporteRegistraduria1() {
    }

    public ReporteRegistraduria1(BigDecimal idRepoestadis1) {
        this.idRepoestadis1 = idRepoestadis1;
    }

    public String getCalifiRegistraduria() {
        return califiRegistraduria;
    }

    public void setCalifiRegistraduria(String califiRegistraduria) {
        this.califiRegistraduria = califiRegistraduria;
    }

    public String getCalifiTipodocRegistraduria() {
        return califiTipodocRegistraduria;
    }

    public void setCalifiTipodocRegistraduria(String califiTipodocRegistraduria) {
        this.califiTipodocRegistraduria = califiTipodocRegistraduria;
    }

    public String getTipodocRegis() {
        return tipodocRegis;
    }

    public void setTipodocRegis(String tipodocRegis) {
        this.tipodocRegis = tipodocRegis;
    }

    public String getPrimeApellidoRegis() {
        return primeApellidoRegis;
    }

    public void setPrimeApellidoRegis(String primeApellidoRegis) {
        this.primeApellidoRegis = primeApellidoRegis;
    }

    public String getSegundoApellidoRegis() {
        return segundoApellidoRegis;
    }

    public void setSegundoApellidoRegis(String segundoApellidoRegis) {
        this.segundoApellidoRegis = segundoApellidoRegis;
    }

    public String getPrimeNombreRegis() {
        return primeNombreRegis;
    }

    public void setPrimeNombreRegis(String primeNombreRegis) {
        this.primeNombreRegis = primeNombreRegis;
    }

    public String getSegundoNombreRegis() {
        return segundoNombreRegis;
    }

    public void setSegundoNombreRegis(String segundoNombreRegis) {
        this.segundoNombreRegis = segundoNombreRegis;
    }

    public String getTipodocInfrac() {
        return tipodocInfrac;
    }

    public void setTipodocInfrac(String tipodocInfrac) {
        this.tipodocInfrac = tipodocInfrac;
    }

    public String getApellido1Infrac() {
        return apellido1Infrac;
    }

    public void setApellido1Infrac(String apellido1Infrac) {
        this.apellido1Infrac = apellido1Infrac;
    }

    public String getApellido2Infrac() {
        return apellido2Infrac;
    }

    public void setApellido2Infrac(String apellido2Infrac) {
        this.apellido2Infrac = apellido2Infrac;
    }

    public String getNombre1Infrac() {
        return nombre1Infrac;
    }

    public void setNombre1Infrac(String nombre1Infrac) {
        this.nombre1Infrac = nombre1Infrac;
    }

    public String getNombre2Infrac() {
        return nombre2Infrac;
    }

    public void setNombre2Infrac(String nombre2Infrac) {
        this.nombre2Infrac = nombre2Infrac;
    }

    public String getDocumentoRegis() {
        return documentoRegis;
    }

    public void setDocumentoRegis(String documentoRegis) {
        this.documentoRegis = documentoRegis;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public BigDecimal getIdRepoestadis1() {
        return idRepoestadis1;
    }

    public void setIdRepoestadis1(BigDecimal idRepoestadis1) {
        this.idRepoestadis1 = idRepoestadis1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepoestadis1 != null ? idRepoestadis1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteRegistraduria1)) {
            return false;
        }
        ReporteRegistraduria1 other = (ReporteRegistraduria1) object;
        if ((this.idRepoestadis1 == null && other.idRepoestadis1 != null) || (this.idRepoestadis1 != null && !this.idRepoestadis1.equals(other.idRepoestadis1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bisacorporation.entities.ReporteRegistraduria1[ idRepoestadis1=" + idRepoestadis1 + " ]";
    }
    
}
