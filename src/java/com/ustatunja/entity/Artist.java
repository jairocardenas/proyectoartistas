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
@Table(name = "artist")
public class Artist implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idartist")
    private Integer idartist;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "display_name", nullable = false)
    private String display_name;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "paypal_email", nullable = false)
    private String paypal_email;

    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idartist")
    private Collection<ArtOrder> artOrderCollection;

    public Artist() {
    }

    public Artist(Integer idartist, String display_name, String email, String paypal_email, String password, boolean active, Collection<ArtOrder> artOrderCollection) {
        this.idartist = idartist;
        this.display_name = display_name;
        this.email = email;
        this.paypal_email = paypal_email;
        this.password = password;
        this.active = active;
        this.artOrderCollection = artOrderCollection;
    }

    public Integer getIdartist() {
        return idartist;
    }

    public void setIdartist(Integer idartist) {
        this.idartist = idartist;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaypal_email() {
        return paypal_email;
    }

    public void setPaypal_email(String paypal_email) {
        this.paypal_email = paypal_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Collection<ArtOrder> getArtOrderCollection() {
        return artOrderCollection;
    }

    public void setArtOrderCollection(Collection<ArtOrder> artOrderCollection) {
        this.artOrderCollection = artOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.idartist);
        hash = 79 * hash + Objects.hashCode(this.display_name);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.paypal_email);
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + (this.active ? 1 : 0);
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
        final Artist other = (Artist) obj;
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.display_name, other.display_name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.paypal_email, other.paypal_email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.idartist, other.idartist)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Artist{" + "idartist=" + idartist + ", display_name=" + display_name + ", email=" + email + ", paypal_email=" + paypal_email + ", password=" + password + ", active=" + active + '}';
    }

}
