package com.ustatunja.facade;

import com.ustatunja.entity.Invoice;
import com.ustatunja.entity.ProductType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InvoiceFacade extends AbstractFacade<Invoice> {

    @PersistenceContext(name = "ProyectoMusicaPU")
    private EntityManager em;

    public InvoiceFacade() {
        super(Invoice.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
}
