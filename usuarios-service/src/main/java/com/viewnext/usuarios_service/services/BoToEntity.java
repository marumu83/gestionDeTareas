package com.viewnext.usuarios_service.services;

import com.viewnext.usuarios_service.persistencia.model.Usuario;
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
     * @param modelMapper
     */
    public BoToEntity(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }


    /**
     * Metodo publico que mapea un objeto TareaBO de negocio
     * a un objeto Tarea de tipo entidad
     * @param usuarioBo
     * @return
     */

    public Usuario usuarioBoToEntity(UsuarioBO usuarioBo) {

        return modelMapper.map(usuarioBo, Usuario.class);
    }
}