/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ustatunja.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    private ProductType idproducttype;
}
