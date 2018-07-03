/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebita
 */
@Entity
@Table(name = "viaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v")
    , @NamedQuery(name = "Viaje.findByIdViaje", query = "SELECT v FROM Viaje v WHERE v.idViaje = :idViaje")
    , @NamedQuery(name = "Viaje.findByDestino", query = "SELECT v FROM Viaje v WHERE v.destino = :destino")
    , @NamedQuery(name = "Viaje.findByFecha", query = "SELECT v FROM Viaje v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Viaje.findByHora", query = "SELECT v FROM Viaje v WHERE v.hora = :hora")
    , @NamedQuery(name = "Viaje.findByCantidadPasajeros", query = "SELECT v FROM Viaje v WHERE v.cantidadPasajeros = :cantidadPasajeros")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idViaje")
    private Integer idViaje;
    @Basic(optional = false)
    @Column(name = "destino")
    private String destino;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @Column(name = "cantidadPasajeros")
    private int cantidadPasajeros;
    @JoinColumn(name = "rutChofer", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Chofer rutChofer;

    public Viaje() {
    }

    public Viaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Viaje(Integer idViaje, String destino, Date fecha, Date hora, int cantidadPasajeros) {
        this.idViaje = idViaje;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Chofer getRutChofer() {
        return rutChofer;
    }

    public void setRutChofer(Chofer rutChofer) {
        this.rutChofer = rutChofer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViaje != null ? idViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.idViaje == null && other.idViaje != null) || (this.idViaje != null && !this.idViaje.equals(other.idViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entidades.Viaje[ idViaje=" + idViaje + " ]";
    }
    
}
