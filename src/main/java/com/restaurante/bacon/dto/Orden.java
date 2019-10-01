/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.bacon.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "ORDEN")
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ORD")
    @SequenceGenerator(name = "SEC_ORD", sequenceName = "SEC_ORDEN", allocationSize = 1)
    @NotNull
    @Column(name = "ID_ORDEN")
    private BigDecimal idOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_TOTAL")
    private BigInteger subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IVA")
    private BigInteger iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_ORDEN")
    private BigInteger totalOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIEMPO_PREPARACION")
    private BigInteger tiempoPreparacion;
    @Size(max = 250)
    @Column(name = "MOTIVO_ANULACION")
    private String motivoAnulacion;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "ID_ESTADO_ORDEN", referencedColumnName = "ID_ESTADO_ORDEN")
    @ManyToOne(optional = false)
    private EstadoOrden idEstadoOrden;
    
    @Column(name = "TIPO_ORDEN")
    private BigInteger tipoOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_orden")
    private Collection<RecetaOrdenada> recetaOrdenadaCollection;

    public Orden() {
    }

    public Orden(BigDecimal idOrden) {
        this.idOrden = idOrden;
    }

    public Orden(BigDecimal idOrden, String descripcion, BigInteger subTotal, BigInteger iva, BigInteger totalOrden, BigInteger tiempoPreparacion,String motivoAnulacion, BigInteger tipoOrden) {
        this.idOrden = idOrden;
        this.descripcion = descripcion;
        this.subTotal = subTotal;
        this.iva = iva;
        this.totalOrden = totalOrden;
        this.tiempoPreparacion = tiempoPreparacion;
        this.motivoAnulacion = motivoAnulacion;
        this.tipoOrden = tipoOrden;
    }

    public BigDecimal getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(BigDecimal idOrden) {
        this.idOrden = idOrden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigInteger subTotal) {
        this.subTotal = subTotal;
    }

    public BigInteger getIva() {
        return iva;
    }

    public void setIva(BigInteger iva) {
        this.iva = iva;
    }

    public BigInteger getTotalOrden() {
        return totalOrden;
    }

    public void setTotalOrden(BigInteger totalOrden) {
        this.totalOrden = totalOrden;
    }

    public BigInteger getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(BigInteger tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }

    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public EstadoOrden getIdEstadoOrden() {
        return idEstadoOrden;
    }

    public void setIdEstadoOrden(EstadoOrden idEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
    }
    
        public BigInteger getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(BigInteger TipoOrden) {
        this.tipoOrden= tipoOrden;
    }

    @XmlTransient
    public Collection<RecetaOrdenada> getRecetaOrdenadaCollection() {
        return recetaOrdenadaCollection;
    }

    public void setRecetaOrdenadaCollection(Collection<RecetaOrdenada> recetaOrdenadaCollection) {
        this.recetaOrdenadaCollection = recetaOrdenadaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    
}
