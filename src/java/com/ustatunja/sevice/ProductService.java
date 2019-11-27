/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.controller.ProductController;
import com.ustatunja.entity.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author USUARIO
 */
@WebService(serviceName = "ProductService")
public class ProductService {

    @EJB
    private ProductController objController;

    public ProductService() {
    }

//    @WebMethod(operationName = "add")
//    public String add(@WebParam(name = "idproducttype") int idproducttype, @WebParam(name = "name") String tittle, @WebParam(name = "description") String description) {
//
//        return objController.add(idproducttype, tittle, description );
//    }
    @WebMethod(operationName = "addProduct")
    public String addProduct(@WebParam(name = "idproducttype") int idproducttype, @WebParam(name = "title") String title, @WebParam(name = "description") String description){
        return objController.add(idproducttype, title, description);
    }
    

    @WebMethod(operationName = "listProduct")
    public List<Product> list() {
        return objController.getProduct();
    }
    
//    @WebMethod(operationName = "deleteProduct")
//    public String deleteProduct(@WebParam(name = "id") Integer id){
//        return objController.deleteArtist(objController.findProduct(id));
//    }
}
