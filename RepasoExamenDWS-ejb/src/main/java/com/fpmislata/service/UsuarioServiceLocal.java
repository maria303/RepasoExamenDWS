/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Usuario;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface UsuarioServiceLocal {

    Usuario login(Usuario usuario);
    
}
