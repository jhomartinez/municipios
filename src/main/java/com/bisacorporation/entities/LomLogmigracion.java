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
@Table(name = "LOM_LOGMIGRACION", schema="CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LomLogmigracion.findAll", query = "SELECT l FROM LomLogmigracion l"),
    @NamedQuery(name = "LomLogmigracion.findByLomIdlogmigracion", query = "SELECT l FROM LomLogmigracion l WHERE l.lomIdlogmigracion = :lomIdlogmigracion"),
    @NamedQuery(name = "LomLogmigracion.findByLomIdproceso", query = "SELECT l FROM LomLogmigracion l WHERE l.lomIdproceso = :lomIdproceso"),
    @NamedQuery(name = "LomLogmigracion.findByMigIdmigracion", query = "SELECT l FROM LomLogmigracion l WHERE l.migIdmigracion = :migIdmigracion"),
    @NamedQuery(name = "LomLogmigracion.findByLomFechainicial", query = "SELECT l FROM LomLogmigracion l WHERE l.lomFechainicial = :lomFechainicial"),
    @NamedQuery(name = "LomLogmigracion.findByLomFechafinal", query = "SELECT l FROM LomLogmigracion l WHERE l.lomFechafinal = :lomFechafinal"),
    @NamedQuery(name = "LomLogmigracion.findByLomEjecutados", query = "SELECT l FROM LomLogmigracion l WHERE l.lomEjecutados = :lomEjecutados"),
    @NamedQuery(name = "LomLogmigracion.findByMrtIdmigregtipoactual", query = "SELECT l FROM LomLogmigracion l WHERE l.mrtIdmigregtipoactual = :mrtIdmigregtipoactual"),
    @NamedQuery(name = "LomLogmigracion.findByLomEstadomigracion", query = "SELECT l FROM LomLogmigracion l WHERE l.lomEstadomigracion = :lomEstadomigracion"),
    @NamedQuery(name = "LomLogmigracion.findByLomEstadoRegistro", query = "SELECT l FROM LomLogmigracion l WHERE l.lomEstadoRegistro = :lomEstadoRegistro"),
    @NamedQuery(name = "LomLogmigracion.findByLomFechacreacion", query = "SELECT l FROM LomLogmigracion l WHERE l.lomFechacreacion = :lomFechacreacion"),
    @NamedQuery(name = "LomLogmigracion.findByLmrFechamodificacion", query = "SELECT l FROM LomLogmigracion l WHERE l.lmrFechamodificacion = :lmrFechamodificacion"),
    @NamedQuery(name = "LomLogmigracion.findByLmrUsuariocreacion", query = "SELECT l FROM LomLogmigracion l WHERE l.lmrUsuariocreacion = :lmrUsuariocreacion"),
    @NamedQuery(name = "LomLogmigracion.findByLmrUsuariomodificacion", query = "SELECT l FROM LomLogmigracion l WHERE l.lmrUsuariomodificacion = :lmrUsuariomodificacion")})
public class LomLogmigracion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOM_IDLOGMIGRACION")
    private BigDecimal lomIdlogmigracion;
    @Column(name = "LOM_IDPROCESO")
    private BigInteger lomIdproceso;
    @Column(name = "MIG_IDMIGRACION")
    private BigInteger migIdmigracion;
    @Column(name = "LOM_FECHAINICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lomFechainicial;
    @Column(name = "LOM_FECHAFINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lomFechafinal;
    @Column(name = "LOM_EJECUTADOS")
    private BigInteger lomEjecutados;
    @Column(name = "MRT_IDMIGREGTIPOACTUAL")
    private BigInteger mrtIdmigregtipoactual;
    @Column(name = "LOM_ESTADOMIGRACION")
    private Character lomEstadomigracion;
    @Column(name = "LOM_ESTADO_REGISTRO")
    private Character lomEstadoRegistro;
    @Column(name = "LOM_FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lomFechacreacion;
    @Column(name = "LMR_FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lmrFechamodificacion;
    @Size(max = 30)
    @Column(name = "LMR_USUARIOCREACION")
    private String lmrUsuariocreacion;
    @Size(max = 30)
    @Column(name = "LMR_USUARIOMODIFICACION")
    private String lmrUsuariomodificacion;

    public LomLogmigracion() {
    }

    public LomLogmigracion(BigDecimal lomIdlogmigracion) {
        this.lomIdlogmigracion = lomIdlogmigracion;
    }

    public BigDecimal getLomIdlogmigracion() {
        return lomIdlogmigracion;
    }

    public void setLomIdlogmigracion(BigDecimal lomIdlogmigracion) {
        this.lomIdlogmigracion = lomIdlogmigracion;
    }

    public BigInteger getLomIdproceso() {
        return lomIdproceso;
    }

    public void setLomIdproceso(BigInteger lomIdproceso) {
        this.lomIdproceso = lomIdproceso;
    }

    public BigInteger getMigIdmigracion() {
        return migIdmigracion;
    }

    public void setMigIdmigracion(BigInteger migIdmigracion) {
        this.migIdmigracion = migIdmigracion;
    }

    public Date getLomFechainicial() {
        return lomFechainicial;
    }

    public void setLomFechainicial(Date lomFechainicial) {
        this.lomFechainicial = lomFechainicial;
    }

    public Date getLomFechafinal() {
        return lomFechafinal;
    }

    public void setLomFechafinal(Date lomFechafinal) {
        this.lomFechafinal = lomFechafinal;
    }

    public BigInteger getLomEjecutados() {
        return lomEjecutados;
    }

    public void setLomEjecutados(BigInteger lomEjecutados) {
        this.lomEjecutados = lomEjecutados;
    }

    public BigInteger getMrtIdmigregtipoactual() {
        return mrtIdmigregtipoactual;
    }

    public void setMrtIdmigregtipoactual(BigInteger mrtIdmigregtipoactual) {
        this.mrtIdmigregtipoactual = mrtIdmigregtipoactual;
    }

    public Character getLomEstadomigracion() {
        return lomEstadomigracion;
    }

    public void setLomEstadomigracion(Character lomEstadomigracion) {
        this.lomEstadomigracion = lomEstadomigracion;
    }

    public Character getLomEstadoRegistro() {
        return lomEstadoRegistro;
    }

    public void setLomEstadoRegistro(Character lomEstadoRegistro) {
        this.lomEstadoRegistro = lomEstadoRegistro;
    }

    public Date getLomFechacreacion() {
        return lomFechacreacion;
    }

    public void setLomFechacreacion(Date lomFechacreacion) {
        this.lomFechacreacion = lomFechacreacion;
    }

    public Date getLmrFechamodificacion() {
        return lmrFechamodificacion;
    }

    public void setLmrFechamodificacion(Date lmrFechamodificacion) {
        this.lmrFechamodificacion = lmrFechamodificacion;
    }

    public String getLmrUsuariocreacion() {
        return lmrUsuariocreacion;
    }

    public void setLmrUsuariocreacion(String lmrUsuariocreacion) {
        this.lmrUsuariocreacion = lmrUsuariocreacion;
    }

    public String getLmrUsuariomodificacion() {
        return lmrUsuariomodificacion;
    }

    public void setLmrUsuariomodificacion(String lmrUsuariomodificacion) {
        this.lmrUsuariomodificacion = lmrUsuariomodificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lomIdlogmigracion != null ? lomIdlogmigracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LomLogmigracion)) {
            return false;
        }
        LomLogmigracion other = (LomLogmigracion) object;
        if ((this.lomIdlogmigracion == null && other.lomIdlogmigracion != null) || (this.lomIdlogmigracion != null && !this.lomIdlogmigracion.equals(other.lomIdlogmigracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bisacorporation.entities.LomLogmigracion[ lomIdlogmigracion=" + lomIdlogmigracion + " ]";
    }
    
}
