/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entidades.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebita
 */
@Local
public interface ServicioBeanLocal {

    Chofer iniciarSesion(String rut, String clave);

    void guardar(Object object);

    List<Viaje> getViajes();

    Chofer buscarChofer(String rut);
    
}
