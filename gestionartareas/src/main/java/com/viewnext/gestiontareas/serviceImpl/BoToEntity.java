package com.viewnext.gestiontareas.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.viewnext.gestiontareas.persistence.model.Tarea;
import com.viewnext.gestiontareas.service.bo.TareaBO;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
@Configuration
public class BoToEntity {
	
	@Autowired
	ModelMapper modelMapper;
	
	public Tarea tareaBoToEntity(TareaBO tareaBo) {
		
		return modelMapper.map(tareaBo, Tarea.class);
	}

}
