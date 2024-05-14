package com.viewnext.gestiontareas.serviceimpl;

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
public class EntityToBo {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public TareaBO tareaEntityToBo(Tarea tarea) {
		
		return modelMapper.map(tarea, TareaBO.class);
	}

}
