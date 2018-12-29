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
@Table(name = "REPORTE_REGISTRADURIA2", schema = "CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteRegistraduria2.findAll", query = "SELECT r FROM ReporteRegistraduria2 r"),
    @NamedQuery(name = "ReporteRegistraduria2.findByTipodocInfrac", query = "SELECT r FROM ReporteRegistraduria2 r WHERE r.tipodocInfrac = :tipodocInfrac"),
    @NamedQuery(name = "ReporteRegistraduria2.findByApellido1Infrac", query = "SELECT r FROM ReporteRegistraduria2 r WHERE r.apellido1Infrac = :apellido1Infrac"),
    @NamedQuery(name = "ReporteRegistraduria2.findByApellido2Infrac", query = "SELECT r FROM ReporteRegistraduria2 r WHERE r.apellido2Infrac = :apellido2Infrac"),
    @NamedQuery(name = "ReporteRegistraduria2.findByNombre1Infrac", query = "SELECT r FROM ReporteRegistraduria2 r WHERE r.nombre1Infrac = :nombre1Infrac"),
    @NamedQuery(name = "ReporteRegistraduria2.findByNombre2Infrac", query = "SELECT r FROM ReporteRegistraduria2 r WHERE r.nombre2Infrac = :nombre2Infrac"),
    @NamedQuery(name = "ReporteRegistraduria2.findByTipodocInfracCase", query = "SELECT r FROM ReporteRegistraduria2 r WHERE r.tipodocInfracCase = :tipodocInfracCase"),
    @NamedQuery(name = "ReporteRegistraduria2.findByDocumentoInfrac", query = "SELECT r FROM ReporteRegistraduria2 r WHERE r.documentoInfrac = :documentoInfrac"),
    @NamedQuery(name = "ReporteRegistraduria2.findByFechaCarga", query = "SELECT r FROM ReporteRegistraduria2 r WHERE r.fechaCarga = :fechaCarga"),
    @NamedQuery(name = "ReporteRegistraduria2.findByIdRepoestadis2", query = "SELECT r FROM ReporteRegistraduria2 r WHERE r.idRepoestadis2 = :idRepoestadis2")})
public class ReporteRegistraduria2 implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Size(max = 3)
    @Column(name = "TIPODOC_INFRAC_CASE")
    private String tipodocInfracCase;
    @Size(max = 50)
    @Column(name = "DOCUMENTO_INFRAC")
    private String documentoInfrac;
    @Column(name = "FECHA_CARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCarga;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPOESTADIS2")
    private BigDecimal idRepoestadis2;

    public ReporteRegistraduria2() {
    }

    public ReporteRegistraduria2(BigDecimal idRepoestadis2) {
        this.idRepoestadis2 = idRepoestadis2;
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

    public String getTipodocInfracCase() {
        return tipodocInfracCase;
    }

    public void setTipodocInfracCase(String tipodocInfracCase) {
        this.tipodocInfracCase = tipodocInfracCase;
    }

    public String getDocumentoInfrac() {
        return documentoInfrac;
    }

    public void setDocumentoInfrac(String documentoInfrac) {
        this.documentoInfrac = documentoInfrac;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public BigDecimal getIdRepoestadis2() {
        return idRepoestadis2;
    }

    public void setIdRepoestadis2(BigDecimal idRepoestadis2) {
        this.idRepoestadis2 = idRepoestadis2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepoestadis2 != null ? idRepoestadis2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteRegistraduria2)) {
            return false;
        }
        ReporteRegistraduria2 other = (ReporteRegistraduria2) object;
        if ((this.idRepoestadis2 == null && other.idRepoestadis2 != null) || (this.idRepoestadis2 != null && !this.idRepoestadis2.equals(other.idRepoestadis2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bisacorporation.entities.ReporteRegistraduria2[ idRepoestadis2=" + idRepoestadis2 + " ]";
    }
    
}
