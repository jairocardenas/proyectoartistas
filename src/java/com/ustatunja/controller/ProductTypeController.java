package com.ustatunja.controller;

import com.ustatunja.entity.ProductType;
import com.ustatunja.facade.ProductTypeFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ProductTypeController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ProductTypeFacade objFacade;
    private ProductType objCurrent;

    public ProductTypeController() {
//
    }

    public String add(ProductType obj) {

        String title, detail;

        try {
            title = "¡Exito! \n";
            detail = "Se ha guardado correctamente";
            getObjFacade().add(obj);
            return title + detail;

        } catch (Exception e) {
            title = "¡Error! \n";
            detail = "Ha ocurrido un error al guardar.";
            return title + detail;
        }

    }

    public List<ProductType> getProductType() {
        return getObjFacade().loadAll();
    }

    public ProductTypeFacade getObjFacade() {
        return objFacade;
    }

    public String deleteProductType(ProductType objectProductType) {
        String title, detail;

        if (objectProductType.getIdproduct().size() == 0) {
            try {
                this.objCurrent = objectProductType;
                title = "¡Exito! \n";
                detail = "Se ha borrado correctamente";

                getObjFacade().delete(objectProductType);
                this.objCurrent = new ProductType();
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

    public String updateProductType(ProductType objectProductType) {
        String title, detail;
        try {

            title = "¡Exito! \n";
            detail = "Se ha actualizado correctamente";
            getObjFacade().update(objectProductType);
            return title + detail;

        } catch (Exception e) {
            title = "¡Error! \n";
            detail = "Ha ocurrido un error al actualizar.";
            return title + detail;
        }

    }

    public ProductType findProductType(Integer id) {
        return getObjFacade().find(id);
    }

    public void setObjFacade(ProductTypeFacade objFacade) {
        this.objFacade = objFacade;
    }

}
