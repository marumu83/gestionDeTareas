package com.viewnext.gestiontareas.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.viewnext.gestiontareas.persistence.model.Tarea;
import com.viewnext.gestiontareas.persistence.model.Usuario;
import com.viewnext.gestiontareas.service.bo.TareaBO;
import com.viewnext.gestiontareas.service.bo.UsuarioBO;

/**
 * Clase que mapea los objetos de negocio BO a 
 * objetos de tipo modelo
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
@Configuration
public class BoToEntity {	
	
	/**
	 * Instancia de la clase ModelMapper para el mapeo
	 * automatico de las clases
	 */
	
	private final ModelMapper modelMapper;
	
	/**
	 * Constructor parametrizado que inyecta el mapeador
	 * @param modelMapper
	 */
	public BoToEntity(ModelMapper modelMapper) {
		
		this.modelMapper = modelMapper;
	}
	
	/**
	 * Metodo que mapea una tarea objeto de negocio a
	 * un objeto de tipo entidad
	 * @param tareaBo 
	 * @return Tarea
	 */	
	
	public Tarea tareaBoToEntity(TareaBO tareaBo) {
		
		return modelMapper.map(tareaBo, Tarea.class);
	}
	
	/**
	 * Metodo que mapea un usuario objeto de negocio a
	 * un objeto de tipo entidad
	 * @param tareaBo
	 * @return Usuario
	 */	

	public Usuario usuarioBoToEntity(UsuarioBO usuarioBo) {
		
		return modelMapper.map(usuarioBo, Usuario.class);
	}
}
