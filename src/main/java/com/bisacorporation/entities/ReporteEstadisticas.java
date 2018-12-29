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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JHON
 */
@Entity
@Table(name = "REPORTE_ESTADISTICAS", schema = "CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteEstadisticas.findAll", query = "SELECT r FROM ReporteEstadisticas r"),
    @NamedQuery(name = "ReporteEstadisticas.findByFechaPenultcarga", query = "SELECT r FROM ReporteEstadisticas r WHERE r.fechaPenultcarga = :fechaPenultcarga"),
    @NamedQuery(name = "ReporteEstadisticas.findByFechaUltcarga", query = "SELECT r FROM ReporteEstadisticas r WHERE r.fechaUltcarga = :fechaUltcarga"),
    @NamedQuery(name = "ReporteEstadisticas.findByCanRegpenultcruze", query = "SELECT r FROM ReporteEstadisticas r WHERE r.canRegpenultcruze = :canRegpenultcruze"),
    @NamedQuery(name = "ReporteEstadisticas.findByCanRegultcruze", query = "SELECT r FROM ReporteEstadisticas r WHERE r.canRegultcruze = :canRegultcruze"),
    @NamedQuery(name = "ReporteEstadisticas.findByRegCalifi100", query = "SELECT r FROM ReporteEstadisticas r WHERE r.regCalifi100 = :regCalifi100"),
    @NamedQuery(name = "ReporteEstadisticas.findByRegCalifi9099", query = "SELECT r FROM ReporteEstadisticas r WHERE r.regCalifi9099 = :regCalifi9099"),
    @NamedQuery(name = "ReporteEstadisticas.findByRegCalifi8090", query = "SELECT r FROM ReporteEstadisticas r WHERE r.regCalifi8090 = :regCalifi8090"),
    @NamedQuery(name = "ReporteEstadisticas.findByRegCalifi7080", query = "SELECT r FROM ReporteEstadisticas r WHERE r.regCalifi7080 = :regCalifi7080"),
    @NamedQuery(name = "ReporteEstadisticas.findByRegCalifi6070", query = "SELECT r FROM ReporteEstadisticas r WHERE r.regCalifi6070 = :regCalifi6070"),
    @NamedQuery(name = "ReporteEstadisticas.findByRegCalifi5060", query = "SELECT r FROM ReporteEstadisticas r WHERE r.regCalifi5060 = :regCalifi5060"),
    @NamedQuery(name = "ReporteEstadisticas.findByRegCalifiMen50", query = "SELECT r FROM ReporteEstadisticas r WHERE r.regCalifiMen50 = :regCalifiMen50"),
    @NamedQuery(name = "ReporteEstadisticas.findByIdRepoestadis", query = "SELECT r FROM ReporteEstadisticas r WHERE r.idRepoestadis = :idRepoestadis")})
public class ReporteEstadisticas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "FECHA_PENULTCARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPenultcarga;
    @Column(name = "FECHA_ULTCARGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltcarga;
    @Column(name = "CAN_REGPENULTCRUZE")
    private BigInteger canRegpenultcruze;
    @Column(name = "CAN_REGULTCRUZE")
    private BigInteger canRegultcruze;
    @Column(name = "ROWC_PENULTIMO")
    private String rowcPenultimo;
    @Column(name = "ROWC_ULTIMO")
    private String rowcUltimo;
    @Column(name = "REG_CALIFI_100")
    private BigInteger regCalifi100;
    @Column(name = "REG_CALIFI_90_99")
    private BigInteger regCalifi9099;
    @Column(name = "REG_CALIFI_80_90")
    private BigInteger regCalifi8090;
    @Column(name = "REG_CALIFI_70_80")
    private BigInteger regCalifi7080;
    @Column(name = "REG_CALIFI_60_70")
    private BigInteger regCalifi6070;
    @Column(name = "REG_CALIFI_50_60")
    private BigInteger regCalifi5060;
    @Column(name = "REG_CALIFI_MEN_50")
    private BigInteger regCalifiMen50;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPOESTADIS")
    private BigDecimal idRepoestadis;

    public ReporteEstadisticas() {
    }

    public ReporteEstadisticas(BigDecimal idRepoestadis) {
        this.idRepoestadis = idRepoestadis;
    }

    public Date getFechaPenultcarga() {
        return fechaPenultcarga;
    }

    public void setFechaPenultcarga(Date fechaPenultcarga) {
        this.fechaPenultcarga = fechaPenultcarga;
    }

    public Date getFechaUltcarga() {
        return fechaUltcarga;
    }

    public void setFechaUltcarga(Date fechaUltcarga) {
        this.fechaUltcarga = fechaUltcarga;
    }

    public BigInteger getCanRegpenultcruze() {
        return canRegpenultcruze;
    }

    public void setCanRegpenultcruze(BigInteger canRegpenultcruze) {
        this.canRegpenultcruze = canRegpenultcruze;
    }

    public BigInteger getCanRegultcruze() {
        return canRegultcruze;
    }

    public void setCanRegultcruze(BigInteger canRegultcruze) {
        this.canRegultcruze = canRegultcruze;
    }

    public String getRowcPenultimo() {
        return rowcPenultimo;
    }

    public void setRowcPenultimo(String rowcPenultimo) {
        this.rowcPenultimo = rowcPenultimo;
    }

    public String getRowcUltimo() {
        return rowcUltimo;
    }

    public void setRowcUltimo(String rowcUltimo) {
        this.rowcUltimo = rowcUltimo;
    }

    public BigInteger getRegCalifi100() {
        return regCalifi100;
    }

    public void setRegCalifi100(BigInteger regCalifi100) {
        this.regCalifi100 = regCalifi100;
    }

    public BigInteger getRegCalifi9099() {
        return regCalifi9099;
    }

    public void setRegCalifi9099(BigInteger regCalifi9099) {
        this.regCalifi9099 = regCalifi9099;
    }

    public BigInteger getRegCalifi8090() {
        return regCalifi8090;
    }

    public void setRegCalifi8090(BigInteger regCalifi8090) {
        this.regCalifi8090 = regCalifi8090;
    }

    public BigInteger getRegCalifi7080() {
        return regCalifi7080;
    }

    public void setRegCalifi7080(BigInteger regCalifi7080) {
        this.regCalifi7080 = regCalifi7080;
    }

    public BigInteger getRegCalifi6070() {
        return regCalifi6070;
    }

    public void setRegCalifi6070(BigInteger regCalifi6070) {
        this.regCalifi6070 = regCalifi6070;
    }

    public BigInteger getRegCalifi5060() {
        return regCalifi5060;
    }

    public void setRegCalifi5060(BigInteger regCalifi5060) {
        this.regCalifi5060 = regCalifi5060;
    }

    public BigInteger getRegCalifiMen50() {
        return regCalifiMen50;
    }

    public void setRegCalifiMen50(BigInteger regCalifiMen50) {
        this.regCalifiMen50 = regCalifiMen50;
    }

    public BigDecimal getIdRepoestadis() {
        return idRepoestadis;
    }

    public void setIdRepoestadis(BigDecimal idRepoestadis) {
        this.idRepoestadis = idRepoestadis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepoestadis != null ? idRepoestadis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteEstadisticas)) {
            return false;
        }
        ReporteEstadisticas other = (ReporteEstadisticas) object;
        if ((this.idRepoestadis == null && other.idRepoestadis != null) || (this.idRepoestadis != null && !this.idRepoestadis.equals(other.idRepoestadis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bisacorporation.entities.ReporteEstadisticas[ idRepoestadis=" + idRepoestadis + " ]";
    }
    
}
