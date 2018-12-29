/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisacorporation.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "EMI_ERRORMIGRACION", schema = "CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmiErrormigracion.findAll", query = "SELECT e FROM EmiErrormigracion e"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiIderrormigracion", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiIderrormigracion = :emiIderrormigracion"),
    @NamedQuery(name = "EmiErrormigracion.findByPmiIdproceso", query = "SELECT e FROM EmiErrormigracion e WHERE e.pmiIdproceso = :pmiIdproceso"),
    @NamedQuery(name = "EmiErrormigracion.findByMrtIdmigracionregtipo", query = "SELECT e FROM EmiErrormigracion e WHERE e.mrtIdmigracionregtipo = :mrtIdmigracionregtipo"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiFecha", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiFecha = :emiFecha"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiOperacion", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiOperacion = :emiOperacion"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiMensajeerror", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiMensajeerror = :emiMensajeerror"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiCodigoerror", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiCodigoerror = :emiCodigoerror"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiIdregistronuevo", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiIdregistronuevo = :emiIdregistronuevo"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiIdregistroant", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiIdregistroant = :emiIdregistroant"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiEstadoRegistro", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiEstadoRegistro = :emiEstadoRegistro"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiFechacreacion", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiFechacreacion = :emiFechacreacion"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiFechamodificacion", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiFechamodificacion = :emiFechamodificacion"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiUsuariocreacion", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiUsuariocreacion = :emiUsuariocreacion"),
    @NamedQuery(name = "EmiErrormigracion.findByEmiUsuariomodificacion", query = "SELECT e FROM EmiErrormigracion e WHERE e.emiUsuariomodificacion = :emiUsuariomodificacion")})
public class EmiErrormigracion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMI_IDERRORMIGRACION")
    private BigDecimal emiIderrormigracion;
    @Column(name = "PMI_IDPROCESO")
    private BigInteger pmiIdproceso;
    @Column(name = "MRT_IDMIGRACIONREGTIPO")
    private BigInteger mrtIdmigracionregtipo;
    @Column(name = "EMI_FECHA")
    @Temporal(TemporalType.DATE)
    private Date emiFecha;
    @Column(name = "EMI_OPERACION")
    private Character emiOperacion;
    @Size(max = 4000)
    @Column(name = "EMI_MENSAJEERROR")
    private String emiMensajeerror;
    @Size(max = 30)
    @Column(name = "EMI_CODIGOERROR")
    private String emiCodigoerror;
    @Column(name = "EMI_IDREGISTRONUEVO")
    private BigInteger emiIdregistronuevo;
    @Column(name = "EMI_IDREGISTROANT")
    private BigInteger emiIdregistroant;
    @Column(name = "EMI_ESTADO_REGISTRO")
    private Character emiEstadoRegistro;
    @Column(name = "EMI_FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emiFechacreacion;
    @Column(name = "EMI_FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emiFechamodificacion;
    @Size(max = 30)
    @Column(name = "EMI_USUARIOCREACION")
    private String emiUsuariocreacion;
    @Size(max = 30)
    @Column(name = "EMI_USUARIOMODIFICACION")
    private String emiUsuariomodificacion;

    public EmiErrormigracion() {
    }

    public EmiErrormigracion(BigDecimal emiIderrormigracion) {
        this.emiIderrormigracion = emiIderrormigracion;
    }

    public BigDecimal getEmiIderrormigracion() {
        return emiIderrormigracion;
    }

    public void setEmiIderrormigracion(BigDecimal emiIderrormigracion) {
        this.emiIderrormigracion = emiIderrormigracion;
    }

    public BigInteger getPmiIdproceso() {
        return pmiIdproceso;
    }

    public void setPmiIdproceso(BigInteger pmiIdproceso) {
        this.pmiIdproceso = pmiIdproceso;
    }

    public BigInteger getMrtIdmigracionregtipo() {
        return mrtIdmigracionregtipo;
    }

    public void setMrtIdmigracionregtipo(BigInteger mrtIdmigracionregtipo) {
        this.mrtIdmigracionregtipo = mrtIdmigracionregtipo;
    }

    public Date getEmiFecha() {
        return emiFecha;
    }

    public void setEmiFecha(Date emiFecha) {
        this.emiFecha = emiFecha;
    }

    public Character getEmiOperacion() {
        return emiOperacion;
    }

    public void setEmiOperacion(Character emiOperacion) {
        this.emiOperacion = emiOperacion;
    }

    public String getEmiMensajeerror() {
        return emiMensajeerror;
    }

    public void setEmiMensajeerror(String emiMensajeerror) {
        this.emiMensajeerror = emiMensajeerror;
    }

    public String getEmiCodigoerror() {
        return emiCodigoerror;
    }

    public void setEmiCodigoerror(String emiCodigoerror) {
        this.emiCodigoerror = emiCodigoerror;
    }

    public BigInteger getEmiIdregistronuevo() {
        return emiIdregistronuevo;
    }

    public void setEmiIdregistronuevo(BigInteger emiIdregistronuevo) {
        this.emiIdregistronuevo = emiIdregistronuevo;
    }

    public BigInteger getEmiIdregistroant() {
        return emiIdregistroant;
    }

    public void setEmiIdregistroant(BigInteger emiIdregistroant) {
        this.emiIdregistroant = emiIdregistroant;
    }

    public Character getEmiEstadoRegistro() {
        return emiEstadoRegistro;
    }

    public void setEmiEstadoRegistro(Character emiEstadoRegistro) {
        this.emiEstadoRegistro = emiEstadoRegistro;
    }

    public Date getEmiFechacreacion() {
        return emiFechacreacion;
    }

    public void setEmiFechacreacion(Date emiFechacreacion) {
        this.emiFechacreacion = emiFechacreacion;
    }

    public Date getEmiFechamodificacion() {
        return emiFechamodificacion;
    }

    public void setEmiFechamodificacion(Date emiFechamodificacion) {
        this.emiFechamodificacion = emiFechamodificacion;
    }

    public String getEmiUsuariocreacion() {
        return emiUsuariocreacion;
    }

    public void setEmiUsuariocreacion(String emiUsuariocreacion) {
        this.emiUsuariocreacion = emiUsuariocreacion;
    }

    public String getEmiUsuariomodificacion() {
        return emiUsuariomodificacion;
    }

    public void setEmiUsuariomodificacion(String emiUsuariomodificacion) {
        this.emiUsuariomodificacion = emiUsuariomodificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emiIderrormigracion != null ? emiIderrormigracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmiErrormigracion)) {
            return false;
        }
        EmiErrormigracion other = (EmiErrormigracion) object;
        if ((this.emiIderrormigracion == null && other.emiIderrormigracion != null) || (this.emiIderrormigracion != null && !this.emiIderrormigracion.equals(other.emiIderrormigracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bisacorporation.entities.EmiErrormigracion[ emiIderrormigracion=" + emiIderrormigracion + " ]";
    }
    
}
