package com.viewnext.tareas_service.services;

import com.viewnext.tareas_service.persistencia.model.Tarea;
import com.viewnext.tareas_service.services.bo.TareaBO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

/*
 * Clase que mapea los objetos de negocio BO a
 * objetos de entidad
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 *
 */


@Configuration
public class BoToEntity {
    /**
     * Instancia de la clase ModelMapper
     */
    private final ModelMapper modelMapper;


    /**
     * Constructor parametrizado de la clase, inyecta
     * el objeto del mapeador
     *
     * @param modelMapper
     */
    public BoToEntity(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    /**
     * Metodo publico que mapea un objeto de negocio TareaBO
     * a objeto Tarea de tipo entidad
     *
     * @param tareaBo
     * @return
     */
    public Tarea tareaBoToEntity(TareaBO tareaBo) {

        return modelMapper.map(tareaBo, Tarea.class);
    }
}
