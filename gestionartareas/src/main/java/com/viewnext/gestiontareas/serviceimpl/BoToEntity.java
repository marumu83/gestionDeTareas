package com.viewnext.gestiontareas.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.viewnext.gestiontareas.persistence.model.Tarea;
import com.viewnext.gestiontareas.persistence.model.Usuario;
import com.viewnext.gestiontareas.service.bo.TareaBO;
import com.viewnext.gestiontareas.service.bo.UsuarioBO;
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
	 * Metodo publico que mapea un objeto de negocio TareaBO 
	 * a objeto Tarea de tipo entidad
	 * @param tareaBo
	 * @return
	 */
	public Tarea tareaBoToEntity(TareaBO tareaBo) {
		
		return modelMapper.map(tareaBo, Tarea.class);
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
