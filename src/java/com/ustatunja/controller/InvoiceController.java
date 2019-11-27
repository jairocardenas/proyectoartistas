/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.controller;

import com.ustatunja.entity.Invoice;
import com.ustatunja.facade.ArtOrderFacade;
import com.ustatunja.facade.CouponFacade;
import com.ustatunja.facade.InvoiceFacade;
import com.ustatunja.facade.PaymentStatusFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author USUARIO
 */
@Stateless
public class InvoiceController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EJB    
    private InvoiceFacade invoiceFacade;
    @EJB
    private ArtOrderFacade artOrderFacde;
    @EJB
    private PaymentStatusFacade paymenFacade;
    @EJB
    private CouponFacade couponFacade;
    
    private Invoice invoice;

    public InvoiceController() {
    }
    
    public  String addInvoice(int idartorder, int idcoupon, int idpaymentstatus, Date date,float price){
        invoice = new Invoice(date, price);
        invoice.setIdartorder(this.artOrderFacde.find(idartorder));
        invoice.setIdcoupon(this.couponFacade.find(idcoupon));
        invoice.setIdpaymentstatus(this.paymenFacade.find(idpaymentstatus));
        invoiceFacade.add(invoice);
        return "ok";
    }
    
    public List<Invoice> getInvoices(){
        return getInvoiceFacade().loadAll();
    }

    public InvoiceFacade getInvoiceFacade() {
        return invoiceFacade;
    }

    public void setInvoiceFacade(InvoiceFacade invoiceFacade) {
        this.invoiceFacade = invoiceFacade;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
    
    
}
