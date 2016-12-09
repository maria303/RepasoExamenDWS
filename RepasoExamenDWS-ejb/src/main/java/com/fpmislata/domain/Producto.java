/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;

/**
 *
 * @author alumno
 */

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    
    private String nombre;
    private float precio;
    private String ubicacionImagen;

    public Producto(int id, String nombre, float precio, String ubicacionImagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ubicacionImagen = ubicacionImagen;
    }

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUbicacionImagen() {
        return ubicacionImagen;
    }

    public void setUbicacionImagen(String ubicacionImagen) {
        this.ubicacionImagen = ubicacionImagen;
    }
    
}
