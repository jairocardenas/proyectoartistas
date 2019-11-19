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

    public TrackingTicket() {
    }

    public TrackingTicket(Integer idtrackingticket, Date date, TrackingStatus idtrackingstatus) {
        this.idtrackingticket = idtrackingticket;
        this.date = date;
        this.idtrackingstatus = idtrackingstatus;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idtrackingticket);
        hash = 17 * hash + Objects.hashCode(this.date);
        hash = 17 * hash + Objects.hashCode(this.idtrackingstatus);
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
        return true;
    }

    @Override
    public String toString() {
        return "TrackingTicket{" + "idtrackingticket=" + idtrackingticket + ", date=" + date + ", idtrackingstatus=" + idtrackingstatus + '}';
    }
    
    
    

   
    
}
