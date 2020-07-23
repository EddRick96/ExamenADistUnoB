/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carolina.session;

import com.carolina.entidades.Reserva;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dennis
 */
@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> implements ReservaFacadeLocal {

    @PersistenceContext(unitName = "examenCarolina")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaFacade() {
        super(Reserva.class);
    }
    
}
