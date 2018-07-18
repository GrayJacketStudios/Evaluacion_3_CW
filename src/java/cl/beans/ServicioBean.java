/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entidades.Chofer;
import cl.entidades.Viaje;
import com.mysql.jdbc.Blob;
import directorio.Hash;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sebita
 */
@Stateless
public class ServicioBean implements ServicioBeanLocal {
    @PersistenceContext(unitName = "ViajesPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Chofer iniciarSesion(String rut, String clave) {
        try{
            return (Chofer) em.createNamedQuery("Chofer.iniciarSesion", Chofer.class)
                    .setParameter("rut", rut)
                    .setParameter("clave", Hash.md5(clave))
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public void guardar(Object object) {
        em.persist(object);
    }

    
    @Override
    public List<Viaje> getViajes(Chofer chofchof) {
        return em.createQuery("Select v from Viaje v WHERE v.rutChofer.rut = '"+chofchof.getRut()+"' ORDER BY v.destino ASC, v.fecha ASC, v.hora ASC ").getResultList();
    }

    @Override
    public Chofer buscarChofer(String rut) {
        return em.find(Chofer.class, rut);
    }

    @Override
    public Blob getImage(String rut) {
        try{
            return (Blob) em.createQuery("Select c from Chofer c WHERE c.rut = '"+rut+"'")
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public void update(Object nuevo) {
        em.merge(nuevo);
        em.flush();
        
        
    }
    
    
    
    
}
