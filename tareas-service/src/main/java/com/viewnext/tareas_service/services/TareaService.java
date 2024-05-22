package com.viewnext.tareas_service.services;

import com.viewnext.tareas_service.services.bo.TareaBO;

import java.util.List;

/**
 * Interfaz que crea los metodos abstractos para la gestion
 * de las tareas
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
public interface TareaService {

    TareaBO insert (TareaBO tareaBo);

    void deleteTarea (int id);

    TareaBO update (TareaBO tareaBo);

    TareaBO findById(int id);

    List<TareaBO> findAll();

}