/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idartorder")
    private Collection<TrackingTicket> trackingTicketCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idartorder")
    private Collection<Invoice> invoiceCollection;

    public ArtOrder() {
    }

    public ArtOrder(Integer idartorder, Boolean active, Artist idartist, Client idclient, Product idproduct, Collection<TrackingTicket> trackingTicketCollection, Collection<Invoice> invoiceCollection) {
        this.idartorder = idartorder;
        this.active = active;
        this.idartist = idartist;
        this.idclient = idclient;
        this.idproduct = idproduct;
        this.trackingTicketCollection = trackingTicketCollection;
        this.invoiceCollection = invoiceCollection;
    }

    public Integer getIdartorder() {
        return idartorder;
    }

    public void setIdartorder(Integer idartorder) {
        this.idartorder = idartorder;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Artist getIdartist() {
        return idartist;
    }

    public void setIdartist(Artist idartist) {
        this.idartist = idartist;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Product getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Product idproduct) {
        this.idproduct = idproduct;
    }

    public Collection<TrackingTicket> getTrackingTicketCollection() {
        return trackingTicketCollection;
    }

    public void setTrackingTicketCollection(Collection<TrackingTicket> trackingTicketCollection) {
        this.trackingTicketCollection = trackingTicketCollection;
    }

    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.idartorder);
        hash = 73 * hash + Objects.hashCode(this.active);
        hash = 73 * hash + Objects.hashCode(this.idartist);
        hash = 73 * hash + Objects.hashCode(this.idclient);
        hash = 73 * hash + Objects.hashCode(this.idproduct);
        hash = 73 * hash + Objects.hashCode(this.trackingTicketCollection);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArtOrder other = (ArtOrder) obj;
        if (!Objects.equals(this.idartorder, other.idartorder)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.idartist, other.idartist)) {
            return false;
        }
        if (!Objects.equals(this.idclient, other.idclient)) {
            return false;
        }
        if (!Objects.equals(this.idproduct, other.idproduct)) {
            return false;
        }
        if (!Objects.equals(this.trackingTicketCollection, other.trackingTicketCollection)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArtOrder{" + "idartorder=" + idartorder + ", active=" + active + ", idartist=" + idartist + ", idclient=" + idclient + ", idproduct=" + idproduct + ", trackingTicketCollection=" + trackingTicketCollection + '}';
    }

}
