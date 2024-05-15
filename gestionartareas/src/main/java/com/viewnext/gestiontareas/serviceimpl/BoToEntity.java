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
public class BoToEntity {	
	
	private final ModelMapper modelMapper;
	
	public BoToEntity(ModelMapper modelMapper) {
		
		this.modelMapper = modelMapper;
	}
	
	
	public Tarea tareaBoToEntity(TareaBO tareaBo) {
		
		return modelMapper.map(tareaBo, Tarea.class);
	}

	public Usuario usuarioBoToEntity(UsuarioBO usuarioBo) {
		
		return modelMapper.map(usuarioBo, Usuario.class);
	}
}
