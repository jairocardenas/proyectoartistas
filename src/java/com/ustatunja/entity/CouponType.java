
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

@Entity
@Table(name = "coupon_type")
public class CouponType implements Serializable{
private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcoupontype")
    private Integer idcoupontype;
    
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcoupon")
    private Collection<Coupon> couponCollection;

    public CouponType() {
    }

    public CouponType(Integer idcoupontype, String name, Collection<Coupon> couponCollection) {
        this.idcoupontype = idcoupontype;
        this.name = name;
        this.couponCollection = couponCollection;
    }

    public Integer getIdcoupontype() {
        return idcoupontype;
    }

    public void setIdcoupontype(Integer idcoupontype) {
        this.idcoupontype = idcoupontype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Coupon> getCouponCollection() {
        return couponCollection;
    }

    public void setCouponCollection(Collection<Coupon> couponCollection) {
        this.couponCollection = couponCollection;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idcoupontype);
        hash = 53 * hash + Objects.hashCode(this.name);
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
        final CouponType other = (CouponType) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.idcoupontype, other.idcoupontype)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CouponType{" + "idcoupontype=" + idcoupontype + ", name=" + name + ", couponCollection=" + couponCollection + '}';
    }
    
    
}
