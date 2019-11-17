/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author camol
 */
@Entity
@Table(name = "tracking_ticket")
public class TrackingTicket implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "status", referencedColumnName = "id", nullable = false)
    private TrackingStatus status;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "art_order", referencedColumnName = "id", nullable = false)
    private ArtOrder art_order;

    public TrackingTicket() {
    }

    public TrackingTicket(Integer id, Date date, TrackingStatus status, ArtOrder art_order) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.art_order = art_order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TrackingStatus getStatus() {
        return status;
    }

    public void setStatus(TrackingStatus status) {
        this.status = status;
    }

    public ArtOrder getArt_order() {
        return art_order;
    }

    public void setArt_order(ArtOrder art_order) {
        this.art_order = art_order;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.date);
        hash = 37 * hash + Objects.hashCode(this.status);
        hash = 37 * hash + Objects.hashCode(this.art_order);
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
        final TrackingTicket other = (TrackingTicket) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.art_order, other.art_order)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrackingTicket{" + "id=" + id + ", date=" + date + ", status=" + status + ", art_order=" + art_order + '}';
    }

}
