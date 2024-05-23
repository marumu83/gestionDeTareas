package com.viewnext.usuarios_service.persistencia.repository;


import com.viewnext.usuarios_service.persistencia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Interface que extiende de JpaRepository
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

    Usuario findByNombre(String nombre);

    Usuario findByEmail(String email);

}