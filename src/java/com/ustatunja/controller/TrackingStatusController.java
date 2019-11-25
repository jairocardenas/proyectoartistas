/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.controller;

import com.ustatunja.entity.TrackingStatus;
import com.ustatunja.facade.TrackingStatusFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author camol
 */
@SessionScoped
@Named
public class TrackingStatusController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private TrackingStatusFacade ejbFacade;
    private TrackingStatus objtraTrackingStatus;
    private String searchString;

    public TrackingStatusController() {
        this.searchString = "";
    }

    public String add(String name) {
        String title, detail;
        objtraTrackingStatus = new TrackingStatus();
        objtraTrackingStatus.setName(name);
        try {
            title = "Exito";
            detail = "Persona grabada exitosamente.";
            getEjbFacade().add(objtraTrackingStatus);
            return title + "\n" + detail;
        } catch (Exception e) {
            title = "Error";
            detail = "Ha ocurrido un error al grabar.";
            return title + "\n" + detail + "-->" + e;
        }
    }

    public String search(String myFace) {
        return myFace;
    }

    public List<TrackingStatus> getTrackingStatusList() {
        //return getEjbFacade().loadAll();
        return getEjbFacade().loadAll();
    }

    public TrackingStatusFacade getEjbFacade() {
        return this.ejbFacade;
    }

    public void setEjbFacade(TrackingStatusFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public TrackingStatus getObjtraTrackingStatus() {
        return objtraTrackingStatus;
    }

    public void setObjtraTrackingStatus(TrackingStatus objtraTrackingStatus) {
        this.objtraTrackingStatus = objtraTrackingStatus;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

}
