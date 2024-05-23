package com.viewnext.tareas_service.controller;

import com.viewnext.tareas_service.controller.dto.TareaDTO;
import com.viewnext.tareas_service.services.bo.TareaBO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que mapea los objetos de negocio BO a
 * objetos de transferencia de datos DTO
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Configuration
public class BoToDto {

    /**
     * Instancia de la clase ModelMapper para
     * el mapeo automatico de los objetos
     */

    private final ModelMapper modelMapper;

    /**
     * Constructor parametrizado que inyecta modelmapper
     * @param modelMapper
     */

    public BoToDto (ModelMapper modelMapper){
        this.modelMapper= modelMapper;
    }

    /**
     * Metodo que recibe un objeto de negocio de tipo tarea
     * y devuelve un objeto tarea de transferencia de datos
     * @param tareaBo
     * @return TareaDTO
     */

    public TareaDTO tareaBoToDto(TareaBO tareaBo) {

        return modelMapper.map(tareaBo, TareaDTO.class);

    }


}