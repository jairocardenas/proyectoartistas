package com.ustatunja.controller;


import com.ustatunja.entity.TrackingTicket;
import com.ustatunja.facade.TrackingTicketFacade;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TrackingTicketController {

    private static final long serialVersionUID = 1L;

    @EJB
    private TrackingTicketFacade objFacade;
    private TrackingTicket objCurrent;

    public TrackingTicketController() {
    }

    public String add(TrackingTicket object) {
        String title, detail;

        try {
            title = "¡Exito! \n";
            detail = "Se ha guardado correctamente";
            Date currentDate = new Date();
            object.setDate(currentDate);
            getObjFacade().add(object);
            return title + detail;

        } catch (Exception e) {
            title = "¡Error! \n";
            detail = "Ha ocurrido un error al guardar.";
            return title + detail;
        }

    }

    public List<TrackingTicket> list() {
        return getObjFacade().loadAll();
    }

    public TrackingTicketFacade getObjFacade() {
        return objFacade;
    }

    public void setObjFacade(TrackingTicketFacade objFacade) {
        this.objFacade = objFacade;
    }

    public String deleteTrackingTicket(TrackingTicket objTrackingTicket) {
        String title, detail;
        try {
            this.objCurrent = objTrackingTicket;
            title = "Exito";
            detail = "TrackingTicket eliminado";

            getObjFacade().delete(objTrackingTicket);
            this.objCurrent = new TrackingTicket();
            return title + detail;

        } catch (Exception e) {

            title = "Error";
            detail = "Ha ocurrido un error al eliminar";
            return title + detail;
        }

    }

    public String updateTrackingTicket(TrackingTicket objTrackingTicket) {
        String title, detail;
        try {

            title = "¡Exito! \n";
            detail = "Se ha actualizado correctamente";
            getObjFacade().update(objTrackingTicket);
            return title + detail;

        } catch (Exception e) {
            title = "¡Error! \n";
            detail = "Ha ocurrido un error al actualizar.";
            return title + detail;
        }

    }

}
