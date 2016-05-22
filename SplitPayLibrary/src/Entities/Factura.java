/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Viviana
 */
@Entity
@Table(name = "FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdfactura", query = "SELECT f FROM Factura f WHERE f.idfactura = :idfactura"),
    @NamedQuery(name = "Factura.findByTitulo", query = "SELECT f FROM Factura f WHERE f.titulo = :titulo"),
    @NamedQuery(name = "Factura.findByMonto", query = "SELECT f FROM Factura f WHERE f.monto = :monto"),
    @NamedQuery(name = "Factura.findByInformacionopcional", query = "SELECT f FROM Factura f WHERE f.informacionopcional = :informacionopcional"),
    @NamedQuery(name = "Factura.findByUbicacion", query = "SELECT f FROM Factura f WHERE f.ubicacion = :ubicacion"),
    @NamedQuery(name = "Factura.findByTipodegasto", query = "SELECT f FROM Factura f WHERE f.tipodegasto = :tipodegasto"),
    @NamedQuery(name = "Factura.findByComentarios", query = "SELECT f FROM Factura f WHERE f.comentarios = :comentarios")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDFACTURA")
    private BigDecimal idfactura;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "MONTO")
    private double monto;
    @Basic(optional = false)
    @Column(name = "INFORMACIONOPCIONAL")
    private String informacionopcional;
    @Basic(optional = false)
    @Column(name = "UBICACION")
    private String ubicacion;
    @Basic(optional = false)
    @Column(name = "TIPODEGASTO")
    private String tipodegasto;
    @Basic(optional = false)
    @Column(name = "COMENTARIOS")
    private String comentarios;
    @JoinColumn(name = "GRUPO_NOMBRE", referencedColumnName = "NOMBRE")
    @ManyToOne(optional = false)
    private Grupo grupoNombre;

    public Factura() {
    }

    public Factura(BigDecimal idfactura) {
        this.idfactura = idfactura;
    }

    public Factura(BigDecimal idfactura, String titulo, double monto, String informacionopcional, String ubicacion, String tipodegasto, String comentarios) {
        this.idfactura = idfactura;
        this.titulo = titulo;
        this.monto = monto;
        this.informacionopcional = informacionopcional;
        this.ubicacion = ubicacion;
        this.tipodegasto = tipodegasto;
        this.comentarios = comentarios;
    }

    public BigDecimal getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(BigDecimal idfactura) {
        this.idfactura = idfactura;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getInformacionopcional() {
        return informacionopcional;
    }

    public void setInformacionopcional(String informacionopcional) {
        this.informacionopcional = informacionopcional;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipodegasto() {
        return tipodegasto;
    }

    public void setTipodegasto(String tipodegasto) {
        this.tipodegasto = tipodegasto;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Grupo getGrupoNombre() {
        return grupoNombre;
    }

    public void setGrupoNombre(Grupo grupoNombre) {
        this.grupoNombre = grupoNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Factura[ idfactura=" + idfactura + " ]";
    }
    
}
