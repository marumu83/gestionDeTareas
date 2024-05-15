package com.viewnext.gestiontareas.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.viewnext.gestiontareas.persistence.model.Tarea;
import com.viewnext.gestiontareas.persistence.model.Usuario;
import com.viewnext.gestiontareas.service.bo.TareaBO;
import com.viewnext.gestiontareas.service.bo.UsuarioBO;

/**
 * Clase para el mapeo automatico de los objetos tipo modelo
 * a objetos de tipo negocio 
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Configuration
public class EntityToBo {
	
	/**
	 * Instancia de la clase ModelMapper para el mapeo
	 * automatico de las clases
	 */
	
	private final ModelMapper modelMapper;
	
	/**
	 * Constructor parametrizado que inyecta la instancia
	 * de la clase modelmapper
	 * @param modelMapper
	 */
	
	public EntityToBo(ModelMapper modelMapper) {
		
		this.modelMapper = modelMapper;
	}
	
	/**
	 * Metodo para el mapeo de objeto tarea tipo modelo
	 * a objetos tipo negocio
	 * @param modelMapper
	 * @return TareaBO
	 */
	
	public TareaBO tareaEntityToBo(Tarea tarea) {
		
		return modelMapper.map(tarea, TareaBO.class);
	}
	
	/**
	 * Metodo para el mmapeo de objeto usuario de tipo modelo
	 * a objetos de tipo negocio
	 * @param usuario
	 * @return UsuarioBO
	 */
	public UsuarioBO usuarioEntityToBo(Usuario usuario) {
		
		return modelMapper.map(usuario, UsuarioBO.class);
	}

}
