/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Usuario;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class UsuarioService implements UsuarioServiceLocal {

    static ArrayList<Usuario> lista = new ArrayList<>();
    
    static{
        lista.add(new Usuario(1, "11111111A", "Pepito", "Perez", "Calle La Mia", "Valencia", "46900", "123456789", "12345"));
        lista.add(new Usuario(2, "22222222B", "Juan", "Ruiz", "Calle La Suya", "Torrente", "46500", "987654321", "12345"));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Usuario login(Usuario usuario) {
        //Variable que indica si se ha encontrado el usuario
        boolean encontrado = false;
        //Variable auxiliar para devolver el usuario encontrado
        Usuario retorno = null;
        for(int i = 0; i < lista.size() && encontrado == false; i++){
            if(lista.get(i).getDni().equals(usuario.getDni()) && lista.get(i).getPassword().equals(usuario.getPassword())){
                retorno = lista.get(i);
                encontrado = true;
            }
        }
        return retorno;
    }
    
    
}
