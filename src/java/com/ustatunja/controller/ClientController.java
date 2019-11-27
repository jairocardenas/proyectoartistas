package com.ustatunja.controller;

import com.ustatunja.entity.Client;
import com.ustatunja.facade.ClientFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class ClientController {

    private static final long serialVersionUID = 1L;

    @EJB
    private ClientFacade objFacade;
    private Client objCurrent;

    public ClientController() {
    }

    public String add(Client object) {
        String title, detail;

        try {
            title = "¡Exito! \n";
            detail = "Se ha guardado correctamente";
            getObjFacade().add(object);
            return title + detail;

        } catch (Exception e) {
            title = "¡Error! \n";
            detail = "Ha ocurrido un error al guardar.";
            return title + detail;
        }

    }

    public List<Client> list() {
        return getObjFacade().loadAll();
    }

    public ClientFacade getObjFacade() {
        return objFacade;
    }

    public String deleteClient(Client objectClient) {
        String title, detail;

        if (objectClient.getArtOrderCollection().size() == 0) {
            try {
                this.objCurrent = objectClient;
                title = "¡Exito! \n";
                detail = "Se ha borrado correctamente";

                getObjFacade().delete(objectClient);
                this.objCurrent = new Client();
                return title + detail;

            } catch (Exception e) {
                title = "¡Error! \n";
                detail = "Ha ocurrido un error al eliminar.";
                return title + detail;
            }

        } else {
            title = "¡Error! \n";
            detail = "Hay objetos asociados a este cliente.";
            return title + detail;

        }
    }

    public String updateClient(Client objectClient) {
        String title, detail;
        try {

            title = "¡Exito! \n";
            detail = "Se ha actualizado correctamente";
            getObjFacade().update(objectClient);
            return title + detail;

        } catch (Exception e) {
            title = "¡Error! \n";
            detail = "Ha ocurrido un error al actualizar.";
            return title + detail;
        }

    }

}
