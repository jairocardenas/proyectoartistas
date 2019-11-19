/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.facade;

import com.ustatunja.entity.Coupon;
import com.ustatunja.entity.Invoice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CouponFacade extends AbstractFacade<Coupon> {
    
        @PersistenceContext(name = "ProyectoMusicaPU")
    private EntityManager em;

    public CouponFacade() {
        super(Coupon.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
}
