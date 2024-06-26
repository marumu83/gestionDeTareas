package com.viewnext.usuarios_service.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * Interfaz que crea los metodos abstractos para
 * la gestion de los usuarios
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
public interface UsuarioService{

    UsuarioBO insert(UsuarioBO usuarioBo);

    void deleteUsuario(int id);

    UsuarioBO update (UsuarioBO usuarioBO);

    UsuarioBO findById(int id);

    List<UsuarioBO> findAll();

    UsuarioBO findByNombre(String nombre);

    UsuarioBO findByEmail(String email);

    /**
     * @return
     */
    UserDetailsService userDetailsService();

}