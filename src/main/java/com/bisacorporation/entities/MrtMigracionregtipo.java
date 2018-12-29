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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JHON
 */
@Entity
@Table(name = "MRT_MIGRACIONREGTIPO", schema = "CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrtMigracionregtipo.findAll", query = "SELECT m FROM MrtMigracionregtipo m"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtIdmigracionregtipo", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtIdmigracionregtipo = :mrtIdmigracionregtipo"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtDescripcion", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtDescripcion = :mrtDescripcion"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtDescripcionlarga", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtDescripcionlarga = :mrtDescripcionlarga"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtProcesoquemigra", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtProcesoquemigra = :mrtProcesoquemigra"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtFechacompilaproceso", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtFechacompilaproceso = :mrtFechacompilaproceso"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtIdmigregtiposiguient", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtIdmigregtiposiguient = :mrtIdmigregtiposiguient"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtProcpremigra", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtProcpremigra = :mrtProcpremigra"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtProcposmigra", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtProcposmigra = :mrtProcposmigra"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtProcpreinsert", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtProcpreinsert = :mrtProcpreinsert"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtProcposinsert", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtProcposinsert = :mrtProcposinsert"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtProcpreupdate", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtProcpreupdate = :mrtProcpreupdate"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtProcposupdate", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtProcposupdate = :mrtProcposupdate"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtProcpredelete", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtProcpredelete = :mrtProcpredelete"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtProcposdelete", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtProcposdelete = :mrtProcposdelete"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtEstadoregistro", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtEstadoregistro = :mrtEstadoregistro"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtFechacreacion", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtFechacreacion = :mrtFechacreacion"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtFechamodificacion", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtFechamodificacion = :mrtFechamodificacion"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtUsuariocreacion", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtUsuariocreacion = :mrtUsuariocreacion"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtUsuariomodificacion", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtUsuariomodificacion = :mrtUsuariomodificacion"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtTablaorigen", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtTablaorigen = :mrtTablaorigen"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtTabladestino", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtTabladestino = :mrtTabladestino"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtDblinkorigen", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtDblinkorigen = :mrtDblinkorigen"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtDblinkdestino", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtDblinkdestino = :mrtDblinkdestino"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtLlaveorigen", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtLlaveorigen = :mrtLlaveorigen"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtComparaciondelete", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtComparaciondelete = :mrtComparaciondelete"),
    @NamedQuery(name = "MrtMigracionregtipo.findByMrtEstado", query = "SELECT m FROM MrtMigracionregtipo m WHERE m.mrtEstado = :mrtEstado")})
public class MrtMigracionregtipo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MRT_IDMIGRACIONREGTIPO")
    private BigDecimal mrtIdmigracionregtipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "MRT_DESCRIPCION")
    private String mrtDescripcion;
    @Size(max = 4000)
    @Column(name = "MRT_DESCRIPCIONLARGA")
    private String mrtDescripcionlarga;
    @Size(max = 4000)
    @Column(name = "MRT_PROCESOQUEMIGRA")
    private String mrtProcesoquemigra;
    @Column(name = "MRT_FECHACOMPILAPROCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mrtFechacompilaproceso;
    @Column(name = "MRT_IDMIGREGTIPOSIGUIENT")
    private BigInteger mrtIdmigregtiposiguient;
    @Size(max = 4000)
    @Column(name = "MRT_PROCPREMIGRA")
    private String mrtProcpremigra;
    @Size(max = 4000)
    @Column(name = "MRT_PROCPOSMIGRA")
    private String mrtProcposmigra;
    @Size(max = 4000)
    @Column(name = "MRT_PROCPREINSERT")
    private String mrtProcpreinsert;
    @Size(max = 4000)
    @Column(name = "MRT_PROCPOSINSERT")
    private String mrtProcposinsert;
    @Size(max = 4000)
    @Column(name = "MRT_PROCPREUPDATE")
    private String mrtProcpreupdate;
    @Size(max = 4000)
    @Column(name = "MRT_PROCPOSUPDATE")
    private String mrtProcposupdate;
    @Size(max = 4000)
    @Column(name = "MRT_PROCPREDELETE")
    private String mrtProcpredelete;
    @Size(max = 4000)
    @Column(name = "MRT_PROCPOSDELETE")
    private String mrtProcposdelete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MRT_ESTADOREGISTRO")
    private Character mrtEstadoregistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MRT_FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mrtFechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MRT_FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mrtFechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MRT_USUARIOCREACION")
    private String mrtUsuariocreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MRT_USUARIOMODIFICACION")
    private String mrtUsuariomodificacion;
    @Size(max = 100)
    @Column(name = "MRT_TABLAORIGEN")
    private String mrtTablaorigen;
    @Size(max = 100)
    @Column(name = "MRT_TABLADESTINO")
    private String mrtTabladestino;
    @Size(max = 100)
    @Column(name = "MRT_DBLINKORIGEN")
    private String mrtDblinkorigen;
    @Size(max = 100)
    @Column(name = "MRT_DBLINKDESTINO")
    private String mrtDblinkdestino;
    @Column(name = "MRT_LLAVEORIGEN")
    private Character mrtLlaveorigen;
    @Size(max = 4000)
    @Column(name = "MRT_COMPARACIONDELETE")
    private String mrtComparaciondelete;
    @Column(name = "MRT_ESTADO")
    private Character mrtEstado;

    public MrtMigracionregtipo() {
    }

    public MrtMigracionregtipo(BigDecimal mrtIdmigracionregtipo) {
        this.mrtIdmigracionregtipo = mrtIdmigracionregtipo;
    }

    public MrtMigracionregtipo(BigDecimal mrtIdmigracionregtipo, String mrtDescripcion, Character mrtEstadoregistro, Date mrtFechacreacion, Date mrtFechamodificacion, String mrtUsuariocreacion, String mrtUsuariomodificacion) {
        this.mrtIdmigracionregtipo = mrtIdmigracionregtipo;
        this.mrtDescripcion = mrtDescripcion;
        this.mrtEstadoregistro = mrtEstadoregistro;
        this.mrtFechacreacion = mrtFechacreacion;
        this.mrtFechamodificacion = mrtFechamodificacion;
        this.mrtUsuariocreacion = mrtUsuariocreacion;
        this.mrtUsuariomodificacion = mrtUsuariomodificacion;
    }

    public BigDecimal getMrtIdmigracionregtipo() {
        return mrtIdmigracionregtipo;
    }

    public void setMrtIdmigracionregtipo(BigDecimal mrtIdmigracionregtipo) {
        this.mrtIdmigracionregtipo = mrtIdmigracionregtipo;
    }

    public String getMrtDescripcion() {
        return mrtDescripcion;
    }

    public void setMrtDescripcion(String mrtDescripcion) {
        this.mrtDescripcion = mrtDescripcion;
    }

    public String getMrtDescripcionlarga() {
        return mrtDescripcionlarga;
    }

    public void setMrtDescripcionlarga(String mrtDescripcionlarga) {
        this.mrtDescripcionlarga = mrtDescripcionlarga;
    }

    public String getMrtProcesoquemigra() {
        return mrtProcesoquemigra;
    }

    public void setMrtProcesoquemigra(String mrtProcesoquemigra) {
        this.mrtProcesoquemigra = mrtProcesoquemigra;
    }

    public Date getMrtFechacompilaproceso() {
        return mrtFechacompilaproceso;
    }

    public void setMrtFechacompilaproceso(Date mrtFechacompilaproceso) {
        this.mrtFechacompilaproceso = mrtFechacompilaproceso;
    }

    public BigInteger getMrtIdmigregtiposiguient() {
        return mrtIdmigregtiposiguient;
    }

    public void setMrtIdmigregtiposiguient(BigInteger mrtIdmigregtiposiguient) {
        this.mrtIdmigregtiposiguient = mrtIdmigregtiposiguient;
    }

    public String getMrtProcpremigra() {
        return mrtProcpremigra;
    }

    public void setMrtProcpremigra(String mrtProcpremigra) {
        this.mrtProcpremigra = mrtProcpremigra;
    }

    public String getMrtProcposmigra() {
        return mrtProcposmigra;
    }

    public void setMrtProcposmigra(String mrtProcposmigra) {
        this.mrtProcposmigra = mrtProcposmigra;
    }

    public String getMrtProcpreinsert() {
        return mrtProcpreinsert;
    }

    public void setMrtProcpreinsert(String mrtProcpreinsert) {
        this.mrtProcpreinsert = mrtProcpreinsert;
    }

    public String getMrtProcposinsert() {
        return mrtProcposinsert;
    }

    public void setMrtProcposinsert(String mrtProcposinsert) {
        this.mrtProcposinsert = mrtProcposinsert;
    }

    public String getMrtProcpreupdate() {
        return mrtProcpreupdate;
    }

    public void setMrtProcpreupdate(String mrtProcpreupdate) {
        this.mrtProcpreupdate = mrtProcpreupdate;
    }

    public String getMrtProcposupdate() {
        return mrtProcposupdate;
    }

    public void setMrtProcposupdate(String mrtProcposupdate) {
        this.mrtProcposupdate = mrtProcposupdate;
    }

    public String getMrtProcpredelete() {
        return mrtProcpredelete;
    }

    public void setMrtProcpredelete(String mrtProcpredelete) {
        this.mrtProcpredelete = mrtProcpredelete;
    }

    public String getMrtProcposdelete() {
        return mrtProcposdelete;
    }

    public void setMrtProcposdelete(String mrtProcposdelete) {
        this.mrtProcposdelete = mrtProcposdelete;
    }

    public Character getMrtEstadoregistro() {
        return mrtEstadoregistro;
    }

    public void setMrtEstadoregistro(Character mrtEstadoregistro) {
        this.mrtEstadoregistro = mrtEstadoregistro;
    }

    public Date getMrtFechacreacion() {
        return mrtFechacreacion;
    }

    public void setMrtFechacreacion(Date mrtFechacreacion) {
        this.mrtFechacreacion = mrtFechacreacion;
    }

    public Date getMrtFechamodificacion() {
        return mrtFechamodificacion;
    }

    public void setMrtFechamodificacion(Date mrtFechamodificacion) {
        this.mrtFechamodificacion = mrtFechamodificacion;
    }

    public String getMrtUsuariocreacion() {
        return mrtUsuariocreacion;
    }

    public void setMrtUsuariocreacion(String mrtUsuariocreacion) {
        this.mrtUsuariocreacion = mrtUsuariocreacion;
    }

    public String getMrtUsuariomodificacion() {
        return mrtUsuariomodificacion;
    }

    public void setMrtUsuariomodificacion(String mrtUsuariomodificacion) {
        this.mrtUsuariomodificacion = mrtUsuariomodificacion;
    }

    public String getMrtTablaorigen() {
        return mrtTablaorigen;
    }

    public void setMrtTablaorigen(String mrtTablaorigen) {
        this.mrtTablaorigen = mrtTablaorigen;
    }

    public String getMrtTabladestino() {
        return mrtTabladestino;
    }

    public void setMrtTabladestino(String mrtTabladestino) {
        this.mrtTabladestino = mrtTabladestino;
    }

    public String getMrtDblinkorigen() {
        return mrtDblinkorigen;
    }

    public void setMrtDblinkorigen(String mrtDblinkorigen) {
        this.mrtDblinkorigen = mrtDblinkorigen;
    }

    public String getMrtDblinkdestino() {
        return mrtDblinkdestino;
    }

    public void setMrtDblinkdestino(String mrtDblinkdestino) {
        this.mrtDblinkdestino = mrtDblinkdestino;
    }

    public Character getMrtLlaveorigen() {
        return mrtLlaveorigen;
    }

    public void setMrtLlaveorigen(Character mrtLlaveorigen) {
        this.mrtLlaveorigen = mrtLlaveorigen;
    }

    public String getMrtComparaciondelete() {
        return mrtComparaciondelete;
    }

    public void setMrtComparaciondelete(String mrtComparaciondelete) {
        this.mrtComparaciondelete = mrtComparaciondelete;
    }

    public Character getMrtEstado() {
        return mrtEstado;
    }

    public void setMrtEstado(Character mrtEstado) {
        this.mrtEstado = mrtEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mrtIdmigracionregtipo != null ? mrtIdmigracionregtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrtMigracionregtipo)) {
            return false;
        }
        MrtMigracionregtipo other = (MrtMigracionregtipo) object;
        if ((this.mrtIdmigracionregtipo == null && other.mrtIdmigracionregtipo != null) || (this.mrtIdmigracionregtipo != null && !this.mrtIdmigracionregtipo.equals(other.mrtIdmigracionregtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bisacorporation.entities.MrtMigracionregtipo[ mrtIdmigracionregtipo=" + mrtIdmigracionregtipo + " ]";
    }
    
}
