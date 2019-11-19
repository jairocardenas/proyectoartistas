/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.facade;

import com.ustatunja.entity.Artist;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author camol
 */
@Stateless
public class ArtistFacade extends AbstractFacade<Artist> {

    @PersistenceContext(name = "ProyectoMusicaPU")
    private EntityManager em;

    public ArtistFacade() {
        super(Artist.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

}
