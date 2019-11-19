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
    private String active;

}
