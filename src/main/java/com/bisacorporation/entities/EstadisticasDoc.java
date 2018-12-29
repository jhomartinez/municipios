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
@Table(name = "ESTADISTICAS_DOC", schema = "CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadisticasDoc.findAll", query = "SELECT e FROM EstadisticasDoc e"),
    @NamedQuery(name = "EstadisticasDoc.findByFechaPenultcarga", query = "SELECT e FROM EstadisticasDoc e WHERE e.fechaPenultcarga = :fechaPenultcarga"),
    @NamedQuery(name = "EstadisticasDoc.findByFechaUltcarga", query = "SELECT e FROM EstadisticasDoc e WHERE e.fechaUltcarga = :fechaUltcarga"),
    @NamedQuery(name = "EstadisticasDoc.findByCanregCargpenulcruce", query = "SELECT e FROM EstadisticasDoc e WHERE e.canregCargpenulcruce = :canregCargpenulcruce"),
    @NamedQuery(name = "EstadisticasDoc.findByCanregCargulcruce", query = "SELECT e FROM EstadisticasDoc e WHERE e.canregCargulcruce = :canregCargulcruce"),
    @NamedQuery(name = "EstadisticasDoc.findByIdRepoestadis", query = "SELECT e FROM EstadisticasDoc e WHERE e.idRepoestadis = :idRepoestadis")})
public class EstadisticasDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "FECHA_PENULTCARGA")
    @Temporal(TemporalType.DATE)
    private Date fechaPenultcarga;
    @Column(name = "FECHA_ULTCARGA")
    @Temporal(TemporalType.DATE)
    private Date fechaUltcarga;
    @Column(name = "ROWID_PENULTIMO")
    private String rowidPenultimo;
    @Column(name = "ROWID_ULTIMO")
    private String rowidUltimo;
    @Column(name = "CANREG_CARGPENULCRUCE")
    private BigInteger canregCargpenulcruce;
    @Column(name = "CANREG_CARGULCRUCE")
    private BigInteger canregCargulcruce;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPOESTADIS")
    private BigDecimal idRepoestadis;

    public EstadisticasDoc() {
    }

    public EstadisticasDoc(BigDecimal idRepoestadis) {
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

    public String getRowidPenultimo() {
        return rowidPenultimo;
    }

    public void setRowidPenultimo(String rowidPenultimo) {
        this.rowidPenultimo = rowidPenultimo;
    }

    public String getRowidUltimo() {
        return rowidUltimo;
    }

    public void setRowidUltimo(String rowidUltimo) {
        this.rowidUltimo = rowidUltimo;
    }

    public BigInteger getCanregCargpenulcruce() {
        return canregCargpenulcruce;
    }

    public void setCanregCargpenulcruce(BigInteger canregCargpenulcruce) {
        this.canregCargpenulcruce = canregCargpenulcruce;
    }

    public BigInteger getCanregCargulcruce() {
        return canregCargulcruce;
    }

    public void setCanregCargulcruce(BigInteger canregCargulcruce) {
        this.canregCargulcruce = canregCargulcruce;
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
        if (!(object instanceof EstadisticasDoc)) {
            return false;
        }
        EstadisticasDoc other = (EstadisticasDoc) object;
        if ((this.idRepoestadis == null && other.idRepoestadis != null) || (this.idRepoestadis != null && !this.idRepoestadis.equals(other.idRepoestadis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bisacorporation.entities.EstadisticasDoc[ idRepoestadis=" + idRepoestadis + " ]";
    }
    
}
