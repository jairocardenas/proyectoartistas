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
@Table(name = "client")
public class Client implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclient")
    private Integer idclient;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    private Collection<ArtOrder> artOrderCollection;

    public Client() {
    }

    public Client(Integer idclient, String first_name, String last_name, String email, String password, Boolean active, Collection<ArtOrder> artOrderCollection) {
        this.idclient = idclient;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.active = active;
        this.artOrderCollection = artOrderCollection;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
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
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idclient);
        hash = 53 * hash + Objects.hashCode(this.first_name);
        hash = 53 * hash + Objects.hashCode(this.last_name);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + Objects.hashCode(this.active);
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.first_name, other.first_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.idclient, other.idclient)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "idclient=" + idclient + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", password=" + password + ", active=" + active + '}';
    }

   
}
