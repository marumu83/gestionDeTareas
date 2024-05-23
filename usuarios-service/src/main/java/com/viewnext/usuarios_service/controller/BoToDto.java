package com.viewnext.usuarios_service.controller;

import com.viewnext.usuarios_service.controller.dto.UsuarioDTO;
import com.viewnext.usuarios_service.services.UsuarioBO;
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
    /**
     * Metodo que recibe un objeto de negocio de tipo usuario
     * y devuelve un objeto usuario de transferencia de  datos
     * @param usuarioBO
     * @return UsuarioDTO
     */
    public UsuarioDTO usuarioBoToDto(UsuarioBO usuarioBO) {

        return modelMapper.map(usuarioBO, UsuarioDTO.class);
    }

}