
package com.ustatunja.facade;

import com.ustatunja.entity.CouponType;
import com.ustatunja.entity.Invoice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CouponTypeFacade extends AbstractFacade<CouponType>{
        @PersistenceContext(name = "ProyectoMusicaPU")
    private EntityManager em;

    public CouponTypeFacade() {
        super(CouponType.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
}
