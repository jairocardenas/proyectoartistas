
package com.ustatunja.facade;

import com.ustatunja.entity.Invoice;
import com.ustatunja.entity.PaymentStatus;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PaymentStatusFacade extends AbstractFacade<PaymentStatus>{
        @PersistenceContext(name = "ProyectoMusicaPU")
    private EntityManager em;

    public PaymentStatusFacade() {
        super(PaymentStatus.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
}
