/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Factura;
import com.fpmislata.domain.Usuario;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class FacturaService implements FacturaServiceLocal {

    static ArrayList<Factura> lista = new ArrayList<>();
    private static int lastId = 1;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Factura add(Factura factura) {
        factura.setId(lastId);
        lista.add(factura);
        lastId++;
        return factura;
    }

    @Override
    public ArrayList<Factura> getByUsuario(Usuario usuario) {
        ArrayList<Factura> listaADevolver = new ArrayList<>();
        for(int i = 0; i<lista.size(); i++){
            if(lista.get(i).getUsuario().getId()==usuario.getId()){
                listaADevolver.add(lista.get(i));
            }
        }
        return listaADevolver;
    }
    
}
