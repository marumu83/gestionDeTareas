package com.viewnext.tareas_service.services;

import com.viewnext.tareas_service.persistencia.model.Tarea;
import com.viewnext.tareas_service.services.bo.TareaBO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que mapea los objetos de entidad a
 * objetos de negocio BO
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Configuration
public class EntityToBo {

    /**
     * Instancia de la clase ModelMaper
     */
    private final ModelMapper modelMapper;

    /**
     * Constructor parametrizado, que inyecta la instancia
     * del mapeador automatico
     * @param modelMapper
     */

    public EntityToBo(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    /**
     * Metodo publico que mapea un objeto Tarea de entidad
     * a un objeto TareaBO de negocio
     * @param tarea
     * @return
     */

    public TareaBO tareaEntityToBo(Tarea tarea) {

        return modelMapper.map(tarea, TareaBO.class);
    }


}