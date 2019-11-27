/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.controller.ArtOrderController;
import com.ustatunja.entity.ArtOrder;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author USUARIO
 */
@WebService(serviceName = "ArtOrderService")
public class ArtOrderService {

    @EJB
    private ArtOrderController artOrderController;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "addArtOrder")
    public String addArtOrder(@WebParam(name = "idartist") int idartist, @WebParam(name = "idclient") int idclient, @WebParam(name = "idproduct") int idproduct) {
        return artOrderController.addArtOrder(idartist, idclient, idproduct);
    }
    @WebMethod(operationName = "ListArtOrder")
    public List<ArtOrder> listar(){
        return artOrderController.getArtOrders();
    }
}
