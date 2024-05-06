package com.viewnext.gestiontareas.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewnext.gestiontareas.persistence.model.Tarea;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 * Interface que extiende de JpaRepository
 */

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer>{

}
