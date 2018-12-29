/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisacorporation.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JHON
 */
@Entity
@Table(name = "MIG_MIGRACION", schema = "CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MigMigracion.findAll", query = "SELECT m FROM MigMigracion m"),
    @NamedQuery(name = "MigMigracion.findByMigIdmigracion", query = "SELECT m FROM MigMigracion m WHERE m.migIdmigracion = :migIdmigracion"),
    @NamedQuery(name = "MigMigracion.findByMigDescripcion", query = "SELECT m FROM MigMigracion m WHERE m.migDescripcion = :migDescripcion"),
    @NamedQuery(name = "MigMigracion.findByMrtIdmigracionregtipoini", query = "SELECT m FROM MigMigracion m WHERE m.mrtIdmigracionregtipoini = :mrtIdmigracionregtipoini"),
    @NamedQuery(name = "MigMigracion.findByMigProcposmigracion", query = "SELECT m FROM MigMigracion m WHERE m.migProcposmigracion = :migProcposmigracion"),
    @NamedQuery(name = "MigMigracion.findByMigProcpremigracion", query = "SELECT m FROM MigMigracion m WHERE m.migProcpremigracion = :migProcpremigracion"),
    @NamedQuery(name = "MigMigracion.findByMrtIdmigracionregtipofin", query = "SELECT m FROM MigMigracion m WHERE m.mrtIdmigracionregtipofin = :mrtIdmigracionregtipofin"),
    @NamedQuery(name = "MigMigracion.findByMigEstadomigracion", query = "SELECT m FROM MigMigracion m WHERE m.migEstadomigracion = :migEstadomigracion")})
public class MigMigracion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MIG_IDMIGRACION")
    private BigDecimal migIdmigracion;
    @Size(max = 4000)
    @Column(name = "MIG_DESCRIPCION")
    private String migDescripcion;
    @Column(name = "MRT_IDMIGRACIONREGTIPOINI")
    private BigInteger mrtIdmigracionregtipoini;
    @Size(max = 4000)
    @Column(name = "MIG_PROCPOSMIGRACION")
    private String migProcposmigracion;
    @Size(max = 4000)
    @Column(name = "MIG_PROCPREMIGRACION")
    private String migProcpremigracion;
    @Column(name = "MRT_IDMIGRACIONREGTIPOFIN")
    private BigInteger mrtIdmigracionregtipofin;
    @Column(name = "MIG_ESTADOMIGRACION")
    private Character migEstadomigracion;

    public MigMigracion() {
    }

    public MigMigracion(BigDecimal migIdmigracion) {
        this.migIdmigracion = migIdmigracion;
    }

    public BigDecimal getMigIdmigracion() {
        return migIdmigracion;
    }

    public void setMigIdmigracion(BigDecimal migIdmigracion) {
        this.migIdmigracion = migIdmigracion;
    }

    public String getMigDescripcion() {
        return migDescripcion;
    }

    public void setMigDescripcion(String migDescripcion) {
        this.migDescripcion = migDescripcion;
    }

    public BigInteger getMrtIdmigracionregtipoini() {
        return mrtIdmigracionregtipoini;
    }

    public void setMrtIdmigracionregtipoini(BigInteger mrtIdmigracionregtipoini) {
        this.mrtIdmigracionregtipoini = mrtIdmigracionregtipoini;
    }

    public String getMigProcposmigracion() {
        return migProcposmigracion;
    }

    public void setMigProcposmigracion(String migProcposmigracion) {
        this.migProcposmigracion = migProcposmigracion;
    }

    public String getMigProcpremigracion() {
        return migProcpremigracion;
    }

    public void setMigProcpremigracion(String migProcpremigracion) {
        this.migProcpremigracion = migProcpremigracion;
    }

    public BigInteger getMrtIdmigracionregtipofin() {
        return mrtIdmigracionregtipofin;
    }

    public void setMrtIdmigracionregtipofin(BigInteger mrtIdmigracionregtipofin) {
        this.mrtIdmigracionregtipofin = mrtIdmigracionregtipofin;
    }

    public Character getMigEstadomigracion() {
        return migEstadomigracion;
    }

    public void setMigEstadomigracion(Character migEstadomigracion) {
        this.migEstadomigracion = migEstadomigracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (migIdmigracion != null ? migIdmigracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MigMigracion)) {
            return false;
        }
        MigMigracion other = (MigMigracion) object;
        if ((this.migIdmigracion == null && other.migIdmigracion != null) || (this.migIdmigracion != null && !this.migIdmigracion.equals(other.migIdmigracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bisacorporation.entities.MigMigracion[ migIdmigracion=" + migIdmigracion + " ]";
    }
    
}
