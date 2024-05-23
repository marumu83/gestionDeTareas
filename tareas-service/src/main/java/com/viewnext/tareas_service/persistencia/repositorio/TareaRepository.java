package com.viewnext.tareas_service.persistencia.repositorio;

import com.viewnext.tareas_service.persistencia.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *  * Interface que extiende de JpaRepository
 * @author Manuel Rubio
 * @author Jorge Garrido
 */

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer>{

}