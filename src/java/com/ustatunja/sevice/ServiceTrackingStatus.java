/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.entity.TrackingStatus;
import com.ustatunja.facade.TrackingStatusFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
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
    private TrackingStatus objStatus;

    public ServiceTrackingStatus() {

    }

    /**
     * This is a sample web service operation
     */
    public TrackingStatus getSelected() {
        if (this.objStatus == null) {
            this.objStatus = new TrackingStatus();
        }
        return this.objStatus;
    }

//    @WebMethod(operationName = "add")
//    public String add() {
//        getSelected();
//        objF.add(objStatus);
//        if (objStatus != null) {
//            return "mano ha sido bien";
//        } else {
//            return "Hello " + "sss" + " !";
//        }
//
//    }
    @WebMethod(operationName = "add")
    public String add() {
        getSelected();
        objF.add(objStatus);
        if (objStatus != null) {
            return "mano ha sido bien";
        } else {
            return "Hello " + "sss" + " !";
        }
    }

    @WebMethod(operationName = "list")
    public List<TrackingStatus> getT() {
        return objF.loadAll();
    }
}
