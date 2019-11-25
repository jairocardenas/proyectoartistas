/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.controller.ProductTypeController;
import com.ustatunja.entity.ProductType;
import com.ustatunja.facade.ProductTypeFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author camol
 */
@WebService(serviceName = "ProductTypeService")
public class ProductTypeService {

    @EJB
    private ProductTypeController objController;
    private ProductType objProductType;

    public ProductTypeService() {

    }

    @WebMethod(operationName = "add")
    public String add(@WebParam(name = "name") String txt) {
        objProductType = new ProductType();
        objProductType.setName(txt);
        return objController.add(objProductType);
    }

    @WebMethod(operationName = "list")
    public List<ProductType> list() {
        return objController.getProductType();
    }

}
