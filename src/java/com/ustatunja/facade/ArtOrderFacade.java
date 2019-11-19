/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.facade;

import com.ustatunja.entity.ArtOrder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author camol
 */
@Stateless
public class ArtOrderFacade extends AbstractFacade<ArtOrder> {

    @PersistenceContext(name = "ProyectoMusicaPU")
    private EntityManager em;

    public ArtOrderFacade() {
        super(ArtOrder.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

}
