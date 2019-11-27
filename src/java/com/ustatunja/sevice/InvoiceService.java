/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.controller.InvoiceController;
import com.ustatunja.entity.Invoice;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author USUARIO
 */
@WebService(serviceName = "InvoiceService")
public class InvoiceService {

    /**
     * This is a sample web service operation
     */
    
    @EJB
    private InvoiceController invoiceController;

    public InvoiceService() {
    }
    
    
//    @WebMethod(operationName = "addInvoice")
//    public String addInvoice(@WebParam(name = "idartorder") int idartorder, @WebParam(name = "idcoupon") int idcoupon, @WebParam(name = "idpaymentstatus") int idpaymentstatus, @WebParam(name = "date") Date date, @WebParam(name = "price") float price) {
//        return invoiceController.addInvoice(idartorder, idcoupon, idpaymentstatus, date, price);
//    }
    @WebMethod(operationName = "addInvoice")
    public String addInvoice(@WebParam(name = "idartorder") int idartorder, @WebParam(name = "idcoupon") int idcoupon, @WebParam(name = "idpaymentstatus") int idpaymentstatus, @WebParam(name = "date") Date date, @WebParam(name = "price") float price){
        return invoiceController.addInvoice(idartorder, idcoupon, idpaymentstatus, date, price);
    }
    
    
//    @WebMethod(operationName = "ListInvoice")
//    public List<Invoice> list(){
//        return invoiceController.getInvoices();
//    
//}
}
