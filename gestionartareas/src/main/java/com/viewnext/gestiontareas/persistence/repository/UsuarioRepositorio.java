package com.viewnext.gestiontareas.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewnext.gestiontareas.persistence.model.Usuario;

/**
 * Interface que extiende de JpaRepository
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

}
