/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Viviana
 */
@Entity
@Table(name = "GRUPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByIdgrupo", query = "SELECT g FROM Grupo g WHERE g.idgrupo = :idgrupo"),
    @NamedQuery(name = "Grupo.findByIdlider", query = "SELECT g FROM Grupo g WHERE g.idlider = :idlider"),
    @NamedQuery(name = "Grupo.findByNombre", query = "SELECT g FROM Grupo g WHERE g.nombre = :nombre")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "IDGRUPO")
    private BigInteger idgrupo;
    @Basic(optional = false)
    @Column(name = "IDLIDER")
    private BigInteger idlider;
    @Id
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinTable(name = "GRUPOUSUARIO", joinColumns = {
        @JoinColumn(name = "GRUPO_NOMBRE", referencedColumnName = "NOMBRE")}, inverseJoinColumns = {
        @JoinColumn(name = "USUARIO_IDUSUARIO", referencedColumnName = "IDUSUARIO")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoNombre")
    private List<Factura> facturaList;

    public Grupo() {
    }

    public Grupo(String nombre) {
        this.nombre = nombre;
    }

    public Grupo(String nombre, BigInteger idgrupo, BigInteger idlider) {
        this.nombre = nombre;
        this.idgrupo = idgrupo;
        this.idlider = idlider;
    }

    public BigInteger getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(BigInteger idgrupo) {
        this.idgrupo = idgrupo;
    }

    public BigInteger getIdlider() {
        return idlider;
    }

    public void setIdlider(BigInteger idlider) {
        this.idlider = idlider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Grupo[ nombre=" + nombre + " ]";
    }
    
}
