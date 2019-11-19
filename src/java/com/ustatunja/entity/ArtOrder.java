/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author camol
 */
@Entity
@Table(name = "art_order")
public class ArtOrder implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idartorder")
    private Integer idartorder;

    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idartist", referencedColumnName = "idartist", nullable = false)
    private Artist idartist;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idclient", referencedColumnName = "idclient", nullable = false)
    private Client idclient;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idproduct", referencedColumnName = "idproduct", nullable = false)
    private Product idproduct;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrackingstatus")
    private Collection<TrackingTicket> trackingTicketCollection;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinvoice")
//    private Collection<Invoice> invoiceCollection;
    

}
