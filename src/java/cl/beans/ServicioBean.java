/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entidades.Chofer;
import cl.entidades.Viaje;
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
    public List<Viaje> getViajes() {
        return em.createQuery("Select v from Viaje v").getResultList();
    }

    @Override
    public Chofer buscarChofer(String rut) {
        return em.find(Chofer.class, rut);
    }
    
    
    
    
}
