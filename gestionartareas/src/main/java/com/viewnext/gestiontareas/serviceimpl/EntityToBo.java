package com.viewnext.gestiontareas.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.viewnext.gestiontareas.persistence.model.Tarea;
import com.viewnext.gestiontareas.persistence.model.Usuario;
import com.viewnext.gestiontareas.service.bo.TareaBO;
import com.viewnext.gestiontareas.service.bo.UsuarioBO;

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
