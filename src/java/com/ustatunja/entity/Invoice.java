package com.ustatunja.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinvoice")
    private Integer idinvoice;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Basic(optional = false)
    @NotNull
    @Column(name = "price", nullable = false)
    private Float price;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idartorder", referencedColumnName = "idartorder", nullable = false)
    private ArtOrder idartorder;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idpaymentstatus", referencedColumnName = "idpaymentstatus", nullable = false)
    private PaymentStatus idpaymentstatus;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idcoupon", referencedColumnName = "idcoupon", nullable = false)
    private Coupon idcoupon;

    public Invoice() {
    }

    public Invoice(Date date, Float price) {
        this.date = date;
        this.price = price;
    }

    public Invoice(Integer idinvoice, Date date, Float price, ArtOrder idartorder, PaymentStatus idpaymentstatus, Coupon idcoupon) {
        this.idinvoice = idinvoice;
        this.date = date;
        this.price = price;
        this.idartorder = idartorder;
        this.idpaymentstatus = idpaymentstatus;
        this.idcoupon = idcoupon;
    }

    public Integer getIdinvoice() {
        return idinvoice;
    }

    public void setIdinvoice(Integer idinvoice) {
        this.idinvoice = idinvoice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ArtOrder getIdartorder() {
        return idartorder;
    }

    public void setIdartorder(ArtOrder idartorder) {
        this.idartorder = idartorder;
    }

    public PaymentStatus getIdpaymentstatus() {
        return idpaymentstatus;
    }

    public void setIdpaymentstatus(PaymentStatus idpaymentstatus) {
        this.idpaymentstatus = idpaymentstatus;
    }

    public Coupon getIdcoupon() {
        return idcoupon;
    }

    public void setIdcoupon(Coupon idcoupon) {
        this.idcoupon = idcoupon;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idinvoice);
        hash = 23 * hash + Objects.hashCode(this.date);
        hash = 23 * hash + Objects.hashCode(this.price);
        hash = 23 * hash + Objects.hashCode(this.idartorder);
        hash = 23 * hash + Objects.hashCode(this.idpaymentstatus);
        hash = 23 * hash + Objects.hashCode(this.idcoupon);
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
        final Invoice other = (Invoice) obj;
        if (!Objects.equals(this.idinvoice, other.idinvoice)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.idartorder, other.idartorder)) {
            return false;
        }
        if (!Objects.equals(this.idpaymentstatus, other.idpaymentstatus)) {
            return false;
        }
        if (!Objects.equals(this.idcoupon, other.idcoupon)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Invoice{" + "idinvoice=" + idinvoice + ", date=" + date + ", price=" + price + ", idartorder=" + idartorder + ", idpaymentstatus=" + idpaymentstatus + ", idcoupon=" + idcoupon + '}';
    }

}
