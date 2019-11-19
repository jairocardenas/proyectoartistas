/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.entity.TrackingStatus;
import com.ustatunja.facade.TrackingStatusFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author camol
 */
@WebService(serviceName = "ServiceTrackingStatus")
public class ServiceTrackingStatus implements Serializable {

    @EJB
    private TrackingStatusFacade objF;

    public ServiceTrackingStatus() {

    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String add(@WebParam(name = "name") String name) {
        TrackingStatus objP;
        objP = new TrackingStatus();
        objP.setName(name);
        objF.add(objP);
        if (objP != null) {
            return "mano ha sido bien";
        } else {
            return "Hello " + "sss" + " !";
        }

    }
}
