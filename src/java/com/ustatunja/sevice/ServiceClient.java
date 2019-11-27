/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.sevice;

import com.ustatunja.controller.ClientController;
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
    private ClientController objClientController;
    private Client objClient;

    public ServiceClient() {
        objClient = new Client();
    }

    @WebMethod(operationName = "addClient")
    public String addClient(@WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName,
            @WebParam(name = "email") String email, @WebParam(name = "cont") String cont) {

        objClient.setFirst_name(firstName);
        objClient.setLast_name(lastName);
        objClient.setEmail(email);
        objClient.setPassword(cont);
        objClient.setActive(true);

        return objClientController.add(objClient);

    }

    @WebMethod(operationName = "listClient")
    public List<Client> listClient() {
        return objClientController.list();
    }

}
