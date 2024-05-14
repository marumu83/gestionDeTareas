package com.viewnext.gestiontareas.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.viewnext.gestiontareas.persistence.model.Tarea;
import com.viewnext.gestiontareas.persistence.model.Usuario;
import com.viewnext.gestiontareas.service.bo.TareaBO;
import com.viewnext.gestiontareas.service.bo.UsuarioBO;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Configuration
public class EntityToBo {
	
	
	private final ModelMapper modelMapper;
	
	public EntityToBo(ModelMapper modelMapper) {
		
		this.modelMapper = modelMapper;
	}
	
	public TareaBO tareaEntityToBo(Tarea tarea) {
		
		return modelMapper.map(tarea, TareaBO.class);
	}
	public UsuarioBO usuarioEntityToBo(Usuario usuario) {
		
		return modelMapper.map(usuario, UsuarioBO.class);
	}

}
