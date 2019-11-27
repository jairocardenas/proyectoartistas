//package com.ustatunja.sevice;
//
//import com.ustatunja.controller.TrackingTicketController;
//import com.ustatunja.entity.Artist;
//import com.ustatunja.entity.TrackingStatus;
//import com.ustatunja.entity.TrackingTicket;
//import java.util.Date;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.jws.WebService;
//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//
//@WebService(serviceName = "ServiceArtist")
//public class ServiceTrackingTicket {
//
//    @EJB
//    private TrackingTicketController objTrackingTicketController;
//    private TrackingTicket objTicket;
//
//    public ServiceTrackingTicket() {
//        objTicket = new TrackingTicket();
//    }
//
//    @WebMethod(operationName = "addArtist")
//    public String addArtist(@WebParam(name = "idtrackingstatus") TrackingStatus idtrackingstatus,
//            @WebParam(name = "pEmail") String pEmail, @WebParam(name = "cont") String cont) {
//
//        Date current = new Date();
//        objTicket.setDate(current);
//        objTicket.setIdtrackingstatus(idtrackingstatus);
//        objTicket.setPaypal_email(pEmail);
//        objTicket.setPassword(cont);
//        objTicket.setActive(true);
//
//        return objTrackingTicketController.add(objTicket);
//
//    }
//
//    @WebMethod(operationName = "listArtist")
//    public List<Artist> listArtist() {
//        return objTrackingTicketController.list();
//    }
//
//}
