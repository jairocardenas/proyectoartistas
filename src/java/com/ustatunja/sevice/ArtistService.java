/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.controller.ArtistController;
import com.ustatunja.entity.Artist;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author camol
 */
@WebService(serviceName = "ArtistService")
public class ArtistService {

    @EJB
    private ArtistController objArtistController;
    private Artist objArtist;

    public ArtistService() {
        objArtist = new Artist();
    }

    @WebMethod(operationName = "add")
    public String addArtist(@WebParam(name = "dName") String dName, @WebParam(name = "email") String email,
            @WebParam(name = "pEmail") String pEmail, @WebParam(name = "cont") String cont) {

        objArtist.setDisplay_name(dName);
        objArtist.setEmail(email);
        objArtist.setPaypal_email(pEmail);
        objArtist.setPassword(cont);
        objArtist.setActive(true);

        return objArtistController.add(objArtist);

    }

    @WebMethod(operationName = "listArtist")
    public List<Artist> listArtist() {
        return objArtistController.list();
    }

    @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "id") Integer id) {
        return objArtistController.deleteArtist(objArtistController.findArtist(id));
    }

    @WebMethod(operationName = "actualizar")
    public String actualizar(@WebParam(name = "id") Integer id, @WebParam(name = "dName") String dName, @WebParam(name = "corr") String correo, @WebParam(name = "corP") String corP, @WebParam(name = "pass") String pass, @WebParam(name = "est") boolean est) {

        Artist objTemp;

        objTemp = objArtistController.findArtist(id);
        objTemp.setDisplay_name(dName);
        objTemp.setEmail(correo);
        objTemp.setPaypal_email(corP);
        objTemp.setPassword(pass);
        objTemp.setActive(est);

        return objArtistController.updateArtist(objTemp);

    }

}
