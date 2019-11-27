/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.controller;

import com.ustatunja.entity.Product;
import com.ustatunja.facade.ProductFacade;
import com.ustatunja.facade.ProductTypeFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author USUARIO
 */

@Stateless
public class ProductController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ProductFacade objFacade;
    @EJB
    private ProductTypeFacade objProductTypeFacade;
    private Product objProduct;

    public ProductController() {
    }
    
    
    
    public String add( int idproducttype, String title, String description){
        objProduct = new Product(title, description);
        objProduct.setIdproducttype(this.objProductTypeFacade.find(idproducttype));
        objFacade.add(objProduct);
        if (objFacade != null) {
            return "genial";
        }
        return "paila";
        
    }

    public List<Product> getProduct() {
        return getObjFacade().loadAll();
    }

    public ProductFacade getObjFacade() {
        return objFacade;
    }

    public void setObjFacade(ProductFacade objFacade) {
        this.objFacade = objFacade;
    }

    public ProductTypeFacade getObjProductTypeFacade() {
        return objProductTypeFacade;
    }

    public void setObjProductTypeFacade(ProductTypeFacade objProductTypeFacade) {
        this.objProductTypeFacade = objProductTypeFacade;
    }

    public Product getObjProduct() {
        return objProduct;
    }

    public void setObjProduct(Product objProduct) {
        this.objProduct = objProduct;
    }
    
    public String deleteArtist(Product objectProduct) {
        String title, detail;
        
        if (objectProduct.getArtOrderCollection().size() == 0 ) {
            try {
                this.objProduct = objectProduct;
                title = "¡Exito! \n";
                detail = "Se ha borrado correctamente";
                
                getObjFacade().delete(objectProduct);
                this.objProduct = new Product();
                return title + detail;
                
            } catch (Exception e) {
                title = "¡Error! \n";
                detail = "Ha ocurrido un error al eliminar.";
                return title + detail;
            }
            
        } else {
            title = "¡Error! \n";
            detail = "Hay objetos asociados a este artista.";
            return title + detail;
            
        }
    }
    
    public String updateArtist(Product objectProduct) {
        String title, detail;
        try {
            
            title = "¡Exito! \n";
            detail = "Se ha actualizado correctamente";
            getObjFacade().update(objectProduct);
            return title + detail;
            
        } catch (Exception e) {
            title = "¡Error! \n";
            detail = "Ha ocurrido un error al actualizar.";
            return title + detail;
        }
        
    }
    
    public Product findProduct(Integer id) {
        return getObjFacade().find(id);
    }    
    
    
}
