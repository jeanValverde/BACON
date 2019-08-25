/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.bacon.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "RECETA_ORDENADA")
public class RecetaOrdenada implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RECETA_ORDENADA")
    private BigDecimal idRecetaOrdenada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private BigInteger valor;
    @JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID_ORDEN")
    @ManyToOne(optional = false)
    private Orden idOrden;
    @JoinColumn(name = "ID_RECETA", referencedColumnName = "ID_RECETA")
    @ManyToOne(optional = false)
    private Receta idReceta;

    public RecetaOrdenada() {
    }

    public RecetaOrdenada(BigDecimal idRecetaOrdenada) {
        this.idRecetaOrdenada = idRecetaOrdenada;
    }

    public RecetaOrdenada(BigDecimal idRecetaOrdenada, BigInteger cantidad, BigInteger valor) {
        this.idRecetaOrdenada = idRecetaOrdenada;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public BigDecimal getIdRecetaOrdenada() {
        return idRecetaOrdenada;
    }

    public void setIdRecetaOrdenada(BigDecimal idRecetaOrdenada) {
        this.idRecetaOrdenada = idRecetaOrdenada;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public Orden getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Orden idOrden) {
        this.idOrden = idOrden;
    }

    public Receta getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Receta idReceta) {
        this.idReceta = idReceta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecetaOrdenada != null ? idRecetaOrdenada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecetaOrdenada)) {
            return false;
        }
        RecetaOrdenada other = (RecetaOrdenada) object;
        if ((this.idRecetaOrdenada == null && other.idRecetaOrdenada != null) || (this.idRecetaOrdenada != null && !this.idRecetaOrdenada.equals(other.idRecetaOrdenada))) {
            return false;
        }
        return true;
    }
    
}
