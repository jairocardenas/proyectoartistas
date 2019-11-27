/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.controller;

import com.ustatunja.entity.ArtOrder;
import com.ustatunja.facade.ArtOrderFacade;
import com.ustatunja.facade.ArtistFacade;
import com.ustatunja.facade.ClientFacade;
import com.ustatunja.facade.ProductFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author USUARIO
 */
@Stateless
public class ArtOrderController implements Serializable{
    @EJB
    private ArtOrderFacade artOrderFacade;
    @EJB
    private ArtistFacade artistFacade;
    @EJB
    private ClientFacade clientFacade;
    @EJB 
    private ProductFacade productFacade;
    
    private ArtOrder artOrder;

    public ArtOrderController() {
    }
    
    public String addArtOrder(int idartist, int idclient, int idproduct){
        artOrder = new ArtOrder();
        artOrder.setActive(true);
        artOrder.setIdartist(this.artistFacade.find(idartist));
        artOrder.setIdclient(this.clientFacade.find(idclient));
        artOrder.setIdproduct(this.productFacade.find(idproduct));
        artOrderFacade.add(artOrder);
        return "creado bien";
    }
    
    public List<ArtOrder> getArtOrders(){
        return getArtOrderFacade().loadAll();
    }

    public ArtOrderFacade getArtOrderFacade() {
        return artOrderFacade;
    }

    public void setArtOrderFacade(ArtOrderFacade artOrderFacade) {
        this.artOrderFacade = artOrderFacade;
    }

    public ArtOrder getArtOrder() {
        return artOrder;
    }

    public void setArtOrder(ArtOrder artOrder) {
        this.artOrder = artOrder;
    }
    
    
    
    
}
