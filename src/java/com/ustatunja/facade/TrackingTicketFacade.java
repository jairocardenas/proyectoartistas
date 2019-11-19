/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.facade;

import com.ustatunja.entity.TrackingTicket;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author camol
 */
@Stateless
public class TrackingTicketFacade extends AbstractFacade<TrackingTicket> {

    @PersistenceContext(name = "ProyectoMusicaPU")
    private EntityManager em;

    public TrackingTicketFacade() {
        super(TrackingTicket.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

}
