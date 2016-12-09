/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import java.util.Hashtable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author alumno
 */
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private Usuario usuario;
    private Hashtable<Integer, ProductoComprado> listaCompra;

    public Factura() {
    }

    public Factura(int id, Usuario usuario, Hashtable<Integer, ProductoComprado> listaCompra) {
        this.id = id;
        this.usuario = usuario;
        this.listaCompra = listaCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Hashtable<Integer, ProductoComprado> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(Hashtable<Integer, ProductoComprado> listaCompra) {
        this.listaCompra = listaCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", usuario=" + usuario + ", listaCompra=" + listaCompra + '}';
    }
    
}
