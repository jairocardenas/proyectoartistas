/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.controller;

import com.ustatunja.entity.ProductType;
import com.ustatunja.facade.ProductTypeFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author camol
 */
@Stateless
public class ProductTypeController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ProductTypeFacade objFacade;
    private ProductType objProductType;

    public ProductTypeController() {
        ;
    }

    public String add(ProductType obj) {
        getObjFacade().add(obj);
        if (obj != null) {
            return "ha sido bien";
        } else {
            return "ha sido malo";
        }
    }

    public List<ProductType> getProductType() {
        return getObjFacade().loadAll();
    }

    public ProductTypeFacade getObjFacade() {
        return objFacade;
    }

    public void setObjFacade(ProductTypeFacade objFacade) {
        this.objFacade = objFacade;
    }

    public ProductType getObjProductType() {
        return objProductType;
    }

    public void setObjProductType(ProductType objProductType) {
        this.objProductType = objProductType;
    }

}
