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
@Table(name = "REPORTE_REGISTRADURIA3", schema = "CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteRegistraduria3.findAll", query = "SELECT r FROM ReporteRegistraduria3 r"),
    @NamedQuery(name = "ReporteRegistraduria3.findByCedula", query = "SELECT r FROM ReporteRegistraduria3 r WHERE r.cedula = :cedula"),
    @NamedQuery(name = "ReporteRegistraduria3.findByPrimerNombre", query = "SELECT r FROM ReporteRegistraduria3 r WHERE r.primerNombre = :primerNombre"),
    @NamedQuery(name = "ReporteRegistraduria3.findBySegundoNombre", query = "SELECT r FROM ReporteRegistraduria3 r WHERE r.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "ReporteRegistraduria3.findByPrimerApellido", query = "SELECT r FROM ReporteRegistraduria3 r WHERE r.primerApellido = :primerApellido"),
    @NamedQuery(name = "ReporteRegistraduria3.findBySegundoApellido", query = "SELECT r FROM ReporteRegistraduria3 r WHERE r.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "ReporteRegistraduria3.findByVigencia", query = "SELECT r FROM ReporteRegistraduria3 r WHERE r.vigencia = :vigencia"),
    @NamedQuery(name = "ReporteRegistraduria3.findByFechaCarga", query = "SELECT r FROM ReporteRegistraduria3 r WHERE r.fechaCarga = :fechaCarga"),
    @NamedQuery(name = "ReporteRegistraduria3.findByIdRepoestadis3", query = "SELECT r FROM ReporteRegistraduria3 r WHERE r.idRepoestadis3 = :idRepoestadis3")})
public class ReporteRegistraduria3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "CEDULA")
    private String cedula;
    @Size(max = 50)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Size(max = 50)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Size(max = 100)
    @Column(name = "VIGENCIA")
    private String vigencia;
    @Column(name = "FECHA_CARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCarga;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPOESTADIS3")
    private BigDecimal idRepoestadis3;

    public ReporteRegistraduria3() {
    }

    public ReporteRegistraduria3(BigDecimal idRepoestadis3) {
        this.idRepoestadis3 = idRepoestadis3;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public BigDecimal getIdRepoestadis3() {
        return idRepoestadis3;
    }

    public void setIdRepoestadis3(BigDecimal idRepoestadis3) {
        this.idRepoestadis3 = idRepoestadis3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepoestadis3 != null ? idRepoestadis3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteRegistraduria3)) {
            return false;
        }
        ReporteRegistraduria3 other = (ReporteRegistraduria3) object;
        if ((this.idRepoestadis3 == null && other.idRepoestadis3 != null) || (this.idRepoestadis3 != null && !this.idRepoestadis3.equals(other.idRepoestadis3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bisacorporation.entities.ReporteRegistraduria3[ idRepoestadis3=" + idRepoestadis3 + " ]";
    }
    
}
