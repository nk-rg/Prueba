/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.pruebarest.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_contribuyente")
    private Integer idTipoContribuyente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tipoContribuyente")
    private List<Entidad> tbEntidadList;

    public TipoContribuyente() {
    }

    public TipoContribuyente(Integer idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }

    public TipoContribuyente(Integer idTipoContribuyente, String nombre, boolean estado) {
        this.idTipoContribuyente = idTipoContribuyente;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTipoContribuyente() {
        return idTipoContribuyente;
    }

    public void setIdTipoContribuyente(Integer idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoContribuyente != null ? idTipoContribuyente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContribuyente)) {
            return false;
        }
        TipoContribuyente other = (TipoContribuyente) object;
        if ((this.idTipoContribuyente == null && other.idTipoContribuyente != null) || (this.idTipoContribuyente != null && !this.idTipoContribuyente.equals(other.idTipoContribuyente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aaa.TbTipoContribuyente[ idTipoContribuyente=" + idTipoContribuyente + " ]";
    }
}
