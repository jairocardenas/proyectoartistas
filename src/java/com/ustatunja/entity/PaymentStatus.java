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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "payment_status")
public class PaymentStatus implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpaymentstatus")
    private Integer idpaymentstatus;
    
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaymentstatus")
    private Collection<Invoice> invoiceCollection;

    public PaymentStatus() {
    }

    public PaymentStatus(Integer idpaymentstatus, String name, Collection<Invoice> invoiceCollection) {
        this.idpaymentstatus = idpaymentstatus;
        this.name = name;
        this.invoiceCollection = invoiceCollection;
    }

    public Integer getIdpaymentstatus() {
        return idpaymentstatus;
    }

    public void setIdpaymentstatus(Integer idpaymentstatus) {
        this.idpaymentstatus = idpaymentstatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.idpaymentstatus);
        hash = 43 * hash + Objects.hashCode(this.name);
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
        final PaymentStatus other = (PaymentStatus) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.idpaymentstatus, other.idpaymentstatus)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaymentStatus{" + "idpaymentstatus=" + idpaymentstatus + ", name=" + name + ", invoiceCollection=" + invoiceCollection + '}';
    }
    
    
}
