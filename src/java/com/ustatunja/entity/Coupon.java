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

    private static final long serialVersionUID = 1L;
    
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
    private CouponType idcoupons;

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

    public CouponType getIdcoupons() {
        return idcoupons;
    }

    public void setIdcoupons(CouponType idcoupons) {
        this.idcoupons = idcoupons;
    }
   
    
}
