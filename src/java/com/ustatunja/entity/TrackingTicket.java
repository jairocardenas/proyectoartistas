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
    @Column(name = "idtrackingticket")
    private Integer idtrackingticket;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idtrackingstatus", referencedColumnName = "idtrackingstatus", nullable = false)
    private TrackingStatus idtrackingstatus;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idartorder", referencedColumnName = "idartorder", nullable = false)
    private ArtOrder idartorder;

    public TrackingTicket() {
    }

    public TrackingTicket(Integer idtrackingticket, Date date, TrackingStatus idtrackingstatus, ArtOrder idartorder) {
        this.idtrackingticket = idtrackingticket;
        this.date = date;
        this.idtrackingstatus = idtrackingstatus;
        this.idartorder = idartorder;
    }

    public Integer getIdtrackingticket() {
        return idtrackingticket;
    }

    public void setIdtrackingticket(Integer idtrackingticket) {
        this.idtrackingticket = idtrackingticket;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TrackingStatus getIdtrackingstatus() {
        return idtrackingstatus;
    }

    public void setIdtrackingstatus(TrackingStatus idtrackingstatus) {
        this.idtrackingstatus = idtrackingstatus;
    }

    public ArtOrder getIdartorder() {
        return idartorder;
    }

    public void setIdartorder(ArtOrder idartorder) {
        this.idartorder = idartorder;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idtrackingticket);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + Objects.hashCode(this.idtrackingstatus);
        hash = 53 * hash + Objects.hashCode(this.idartorder);
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
        if (!Objects.equals(this.idtrackingticket, other.idtrackingticket)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.idtrackingstatus, other.idtrackingstatus)) {
            return false;
        }
        if (!Objects.equals(this.idartorder, other.idartorder)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrackingTicket{" + "idtrackingticket=" + idtrackingticket + ", date=" + date + ", idtrackingstatus=" + idtrackingstatus + ", idartorder=" + idartorder + '}';
    }
    
    

   
}
