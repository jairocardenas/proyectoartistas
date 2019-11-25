/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.entity.Client;
import com.ustatunja.facade.ClientFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author camol
 */
@WebService(serviceName = "ServiceClient")
public class ServiceClient {

    @EJB
    private ClientFacade objFacade;

    @WebMethod(operationName = "add")
    public String add(@WebParam(name = "name") String txt) {
        Client objClient = new Client();
        objClient.setFirst_name(txt);
        objClient.setLast_name(txt);
        objClient.setEmail(txt);
        objClient.setPassword(txt);
        objClient.setActive(true);

        objFacade.add(objClient);
        if (objClient != null) {
            return "mano ha sido bien";
        } else {
            return "mal";
        }

    }

    @WebMethod(operationName = "list")
    public List<Client> list() {
        return objFacade.loadAll();
    }
    
    

}
