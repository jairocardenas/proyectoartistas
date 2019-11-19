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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author camol
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct")
    private Integer idproduct;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idproducttype", referencedColumnName = "idproducttype", nullable = false)
    private ProductType idproducttype;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idartorder")
    private Collection<ArtOrder> artOrderCollection;

    public Product() {
    }

    public Product(Integer idproduct, String title, String description, ProductType idproducttype, Collection<ArtOrder> artOrderCollection) {
        this.idproduct = idproduct;
        this.title = title;
        this.description = description;
        this.idproducttype = idproducttype;
        this.artOrderCollection = artOrderCollection;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getIdproducttype() {
        return idproducttype;
    }

    public void setIdproducttype(ProductType idproducttype) {
        this.idproducttype = idproducttype;
    }

    public Collection<ArtOrder> getArtOrderCollection() {
        return artOrderCollection;
    }

    public void setArtOrderCollection(Collection<ArtOrder> artOrderCollection) {
        this.artOrderCollection = artOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idproduct);
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.idproducttype);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.idproduct, other.idproduct)) {
            return false;
        }
        if (!Objects.equals(this.idproducttype, other.idproducttype)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "idproduct=" + idproduct + ", title=" + title + ", description=" + description + ", idproducttype=" + idproducttype + '}';
    }
    
    

}
