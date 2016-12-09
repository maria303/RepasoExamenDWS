/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Producto;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class ProductoService implements ProductoServiceLocal {

    static ArrayList<Producto> lista = new ArrayList<>();
    
    static{
        lista.add(new Producto(1, "Figuras Pop! Capitán América: Civil War Figuras vinilo Funko, juego de 5", 39, "./images/Producto1.jpg"));
        lista.add(new Producto(2, "Figura Agente Carter serie Legends de Capitán América: Civil War (16 cm)", 26, "./images/Producto2.jpg"));
        lista.add(new Producto(3, "Set arco y flechas Ojo de Halcón", 26, "./images/Producto3.jpg"));
        lista.add(new Producto(4, "Juego 3 capuchones de felpa para lápiz MXYZ Marvel", 5, "./images/Producto4.jpg"));
        lista.add(new Producto(5, "Llavero peluche MXYZ Marvel", 6, "./images/Producto5.jpg"));
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList<Producto> getLista() {
        return lista;
    }

    @Override
    public Producto findById(Producto producto) {
        boolean encontrado = false;
        Producto p = null;
        for(int i = 0; i < lista.size() && encontrado == false; i++){
            if(lista.get(i).getId() == producto.getId()){
                p = lista.get(i);
                encontrado = true;
            }
        }
        return p;
    }
    
    
}
