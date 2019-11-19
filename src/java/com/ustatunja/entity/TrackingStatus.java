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

/**
 *
 * @author camol
 */
@Entity
@Table(name = "tracking_status")
public class TrackingStatus implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtrackingstatus")
    private Integer idtrackingstatus;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrackingstatus")
    private Collection<TrackingTicket> personaCollection;

    public TrackingStatus() {
    }

    public TrackingStatus(Integer idtrackingstatus, String name, Collection<TrackingTicket> personaCollection) {
        this.idtrackingstatus = idtrackingstatus;
        this.name = name;
        this.personaCollection = personaCollection;
    }

    public Integer getIdtrackingstatus() {
        return idtrackingstatus;
    }

    public void setIdtrackingstatus(Integer idtrackingstatus) {
        this.idtrackingstatus = idtrackingstatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idtrackingstatus);
        hash = 37 * hash + Objects.hashCode(this.name);
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
        final TrackingStatus other = (TrackingStatus) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.idtrackingstatus, other.idtrackingstatus)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrackingStatus{" + "idtrackingstatus=" + idtrackingstatus + ", name=" + name + '}';
    }

    
    
    
    
    

}
