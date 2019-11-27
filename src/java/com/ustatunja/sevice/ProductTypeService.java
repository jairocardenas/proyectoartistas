/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.controller.ProductTypeController;
import com.ustatunja.entity.ProductType;
import java.util.List;
import javax.ejb.EJB;
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
        objProductType = new ProductType();

    }

    @WebMethod(operationName = "add")
    public String add(@WebParam(name = "name") String txt) {
        objProductType.setName(txt);
        return objController.add(objProductType);
    }

    @WebMethod(operationName = "list")
    public List<ProductType> list() {
        return objController.getProductType();
    }

    @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "id") Integer id) {
        return objController.deleteProductType(objController.findProductType(id));
    }

    @WebMethod(operationName = "update")
    public String update(@WebParam(name = "id") Integer id, @WebParam(name = "text") String text) {
        ProductType objTemp;
        objTemp = objController.findProductType(id);
        objTemp.setName(text);
        return objController.updateProductType(objTemp);
    }

}
