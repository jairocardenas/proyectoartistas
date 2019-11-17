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
public class TrackingStatusController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EJB
    private TrackingStatusFacade ejbFacade;
    private TrackingStatus objCurrent;
    
    public TrackingStatusController() {
        
    }
    
    public String addPerson(String name) {
        String title, detail;
        objCurrent = new TrackingStatus();
        objCurrent.setName(name);
        try {
            title = "Exito";
            detail = "Persona grabada exitosamente.";
            getEjbFacade().add(this.objCurrent);
            return title + "\n" + detail;
        } catch (Exception e) {
            title = "Error";
            detail = "Ha ocurrido un error al grabar.";
            return title + "\n" + detail;
        }
    }
    
    public List<TrackingStatus> getTrackingStatusList() {
        return getEjbFacade().loadAll();
    }
    
    public TrackingStatusFacade getEjbFacade() {
        return this.ejbFacade;
    }
    
    public void setEjbFacade(TrackingStatusFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
    
}
