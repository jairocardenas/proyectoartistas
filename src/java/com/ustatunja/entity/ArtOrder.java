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

/**
 *
 * @author camol
 */
@Entity
@Table(name = "art_order")
public class ArtOrder implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idartorder")
    private Integer idartorder;

    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    private Artist idartist;
    private Client idclient;
    private Product idproduct;

}
