/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.metamodel.SingularAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebita
 */
@Entity
@Table(name = "chofer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chofer.findAll", query = "SELECT c FROM Chofer c")
    , @NamedQuery(name = "Chofer.findByRut", query = "SELECT c FROM Chofer c WHERE c.rut = :rut")
    , @NamedQuery(name = "Chofer.findByNombre", query = "SELECT c FROM Chofer c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Chofer.findByTelefono", query = "SELECT c FROM Chofer c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Chofer.findByEmail", query = "SELECT c FROM Chofer c WHERE c.email = :email")
    , @NamedQuery(name = "Chofer.findByClave", query = "SELECT c FROM Chofer c WHERE c.clave = :clave")
    , @NamedQuery(name = "Chofer.iniciarSesion", query = "SELECT c FROM Chofer c WHERE c.clave = :clave AND c.rut = :rut")})
public class Chofer implements Serializable {

    @Basic(optional = false)
    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutChofer")
    private List<Viaje> viajeList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rut")
    private String rut;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;

    public Chofer() {
    }

    public Chofer(String rut) {
        this.rut = rut;
    }

    public Chofer(String rut, String nombre, String telefono, String email, String clave) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chofer)) {
            return false;
        }
        Chofer other = (Chofer) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entidades.Chofer[ rut=" + rut + " ]";
    }

    @XmlTransient
    public List<Viaje> getViajeList() {
        return viajeList;
    }

    public void setViajeList(List<Viaje> viajeList) {
        this.viajeList = viajeList;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public void setFoto(SingularAttribute<Chofer, byte[]> foto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
