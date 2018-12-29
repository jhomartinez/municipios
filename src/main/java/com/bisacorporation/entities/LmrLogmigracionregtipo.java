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
@Table(name = "LMR_LOGMIGRACIONREGTIPO", schema = "CALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LmrLogmigracionregtipo.findAll", query = "SELECT l FROM LmrLogmigracionregtipo l"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrIdlogmigracion", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrIdlogmigracion = :lmrIdlogmigracion"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByPmiIdproceso", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.pmiIdproceso = :pmiIdproceso"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByMrtIdmigracionregtipo", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.mrtIdmigracionregtipo = :mrtIdmigracionregtipo"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrFechainicial", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrFechainicial = :lmrFechainicial"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrFechafinal", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrFechafinal = :lmrFechafinal"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrInsertados", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrInsertados = :lmrInsertados"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrActualizados", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrActualizados = :lmrActualizados"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrBorrados", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrBorrados = :lmrBorrados"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrErrores", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrErrores = :lmrErrores"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrEstadoRegistro", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrEstadoRegistro = :lmrEstadoRegistro"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrFechacreacion", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrFechacreacion = :lmrFechacreacion"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrFechamodificacion", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrFechamodificacion = :lmrFechamodificacion"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrUsuariocreacion", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrUsuariocreacion = :lmrUsuariocreacion"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrUsuariomodificacion", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrUsuariomodificacion = :lmrUsuariomodificacion"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrSeleccionados", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrSeleccionados = :lmrSeleccionados"),
    @NamedQuery(name = "LmrLogmigracionregtipo.findByLmrSincambios", query = "SELECT l FROM LmrLogmigracionregtipo l WHERE l.lmrSincambios = :lmrSincambios")})
public class LmrLogmigracionregtipo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LMR_IDLOGMIGRACION")
    private BigDecimal lmrIdlogmigracion;
    @Column(name = "PMI_IDPROCESO")
    private BigInteger pmiIdproceso;
    @Column(name = "MRT_IDMIGRACIONREGTIPO")
    private BigInteger mrtIdmigracionregtipo;
    @Column(name = "LMR_FECHAINICIAL")
    @Temporal(TemporalType.DATE)
    private Date lmrFechainicial;
    @Column(name = "LMR_FECHAFINAL")
    @Temporal(TemporalType.DATE)
    private Date lmrFechafinal;
    @Column(name = "LMR_INSERTADOS")
    private BigInteger lmrInsertados;
    @Column(name = "LMR_ACTUALIZADOS")
    private BigInteger lmrActualizados;
    @Column(name = "LMR_BORRADOS")
    private BigInteger lmrBorrados;
    @Column(name = "LMR_ERRORES")
    private BigInteger lmrErrores;
    @Column(name = "LMR_ESTADO_REGISTRO")
    private Character lmrEstadoRegistro;
    @Column(name = "LMR_FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lmrFechacreacion;
    @Column(name = "LMR_FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lmrFechamodificacion;
    @Size(max = 30)
    @Column(name = "LMR_USUARIOCREACION")
    private String lmrUsuariocreacion;
    @Size(max = 30)
    @Column(name = "LMR_USUARIOMODIFICACION")
    private String lmrUsuariomodificacion;
    @Column(name = "LMR_SELECCIONADOS")
    private BigInteger lmrSeleccionados;
    @Column(name = "LMR_SINCAMBIOS")
    private BigInteger lmrSincambios;

    public LmrLogmigracionregtipo() {
    }

    public LmrLogmigracionregtipo(BigDecimal lmrIdlogmigracion) {
        this.lmrIdlogmigracion = lmrIdlogmigracion;
    }

    public BigDecimal getLmrIdlogmigracion() {
        return lmrIdlogmigracion;
    }

    public void setLmrIdlogmigracion(BigDecimal lmrIdlogmigracion) {
        this.lmrIdlogmigracion = lmrIdlogmigracion;
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

    public Date getLmrFechainicial() {
        return lmrFechainicial;
    }

    public void setLmrFechainicial(Date lmrFechainicial) {
        this.lmrFechainicial = lmrFechainicial;
    }

    public Date getLmrFechafinal() {
        return lmrFechafinal;
    }

    public void setLmrFechafinal(Date lmrFechafinal) {
        this.lmrFechafinal = lmrFechafinal;
    }

    public BigInteger getLmrInsertados() {
        return lmrInsertados;
    }

    public void setLmrInsertados(BigInteger lmrInsertados) {
        this.lmrInsertados = lmrInsertados;
    }

    public BigInteger getLmrActualizados() {
        return lmrActualizados;
    }

    public void setLmrActualizados(BigInteger lmrActualizados) {
        this.lmrActualizados = lmrActualizados;
    }

    public BigInteger getLmrBorrados() {
        return lmrBorrados;
    }

    public void setLmrBorrados(BigInteger lmrBorrados) {
        this.lmrBorrados = lmrBorrados;
    }

    public BigInteger getLmrErrores() {
        return lmrErrores;
    }

    public void setLmrErrores(BigInteger lmrErrores) {
        this.lmrErrores = lmrErrores;
    }

    public Character getLmrEstadoRegistro() {
        return lmrEstadoRegistro;
    }

    public void setLmrEstadoRegistro(Character lmrEstadoRegistro) {
        this.lmrEstadoRegistro = lmrEstadoRegistro;
    }

    public Date getLmrFechacreacion() {
        return lmrFechacreacion;
    }

    public void setLmrFechacreacion(Date lmrFechacreacion) {
        this.lmrFechacreacion = lmrFechacreacion;
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

    public BigInteger getLmrSeleccionados() {
        return lmrSeleccionados;
    }

    public void setLmrSeleccionados(BigInteger lmrSeleccionados) {
        this.lmrSeleccionados = lmrSeleccionados;
    }

    public BigInteger getLmrSincambios() {
        return lmrSincambios;
    }

    public void setLmrSincambios(BigInteger lmrSincambios) {
        this.lmrSincambios = lmrSincambios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lmrIdlogmigracion != null ? lmrIdlogmigracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LmrLogmigracionregtipo)) {
            return false;
        }
        LmrLogmigracionregtipo other = (LmrLogmigracionregtipo) object;
        if ((this.lmrIdlogmigracion == null && other.lmrIdlogmigracion != null) || (this.lmrIdlogmigracion != null && !this.lmrIdlogmigracion.equals(other.lmrIdlogmigracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
