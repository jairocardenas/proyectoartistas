/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.controller.TrackingStatusController;
import com.ustatunja.entity.TrackingStatus;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author camol
 */
@WebService(serviceName = "ServiceTrackingStatus")
public class ServiceTrackingStatus {

    private TrackingStatusController objTrackingStatus;

    public ServiceTrackingStatus() {
        objTrackingStatus = new TrackingStatusController();

    }

    @WebMethod(operationName = "addTrackingStatus")
    public String hello(@WebParam(name = "name") String name) {
        return objTrackingStatus.addPerson(name);
    }
}
