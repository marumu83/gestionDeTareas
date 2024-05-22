package com.viewnext.usuarios_service.services;

import com.viewnext.usuarios_service.persistencia.model.Usuario;
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
     * Metodo publico que mapea un objeto Usuario de entidad
     * a un objeto UsuarioBO de negocio
     * @param tarea
     * @return
     */

    public UsuarioBO usuarioEntityToBo(Usuario usuario) {

        return modelMapper.map(usuario, UsuarioBO.class);
    }

}