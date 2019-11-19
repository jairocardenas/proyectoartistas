/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "coupon")
public class Coupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcoupon")
    private Integer idcoupon;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "coupon_number", nullable = false)
    private String coupon_number;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Basic(optional = false)
    @NotNull
    @Column(name = "amount", nullable = false)
    private Float amount;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcoupon")
    private Collection<Invoice> invoiceCollection;
    
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idcoupontype", referencedColumnName = "idcoupontype", nullable = false)
    private CouponType idcoupontype;

    public Coupon() {
    }

    public Coupon(Integer idcoupon, String coupon_number, Date date, Float amount, Collection<Invoice> invoiceCollection, CouponType idcoupontype) {
        this.idcoupon = idcoupon;
        this.coupon_number = coupon_number;
        this.date = date;
        this.amount = amount;
        this.invoiceCollection = invoiceCollection;
        this.idcoupontype = idcoupontype;
    }

    public Integer getIdcoupon() {
        return idcoupon;
    }

    public void setIdcoupon(Integer idcoupon) {
        this.idcoupon = idcoupon;
    }

    public String getCoupon_number() {
        return coupon_number;
    }

    public void setCoupon_number(String coupon_number) {
        this.coupon_number = coupon_number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    public CouponType getIdcoupontype() {
        return idcoupontype;
    }

    public void setIdcoupontype(CouponType idcoupontype) {
        this.idcoupontype = idcoupontype;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idcoupon);
        hash = 29 * hash + Objects.hashCode(this.coupon_number);
        hash = 29 * hash + Objects.hashCode(this.date);
        hash = 29 * hash + Objects.hashCode(this.amount);
        hash = 29 * hash + Objects.hashCode(this.idcoupontype);
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
        final Coupon other = (Coupon) obj;
        if (!Objects.equals(this.coupon_number, other.coupon_number)) {
            return false;
        }
        if (!Objects.equals(this.idcoupon, other.idcoupon)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (!Objects.equals(this.idcoupontype, other.idcoupontype)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coupon{" + "idcoupon=" + idcoupon + ", coupon_number=" + coupon_number + ", date=" + date + ", amount=" + amount + ", invoiceCollection=" + invoiceCollection + ", idcoupontype=" + idcoupontype + '}';
    }
    
    
}
