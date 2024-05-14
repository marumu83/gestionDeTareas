package com.viewnext.gestiontareas.controller;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.viewnext.gestiontareas.controller.dto.TareaDTO;
import com.viewnext.gestiontareas.service.bo.TareaBO;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Configuration
public class DtoToBo {
	
	private final ModelMapper modelMapper;
	
	public DtoToBo(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public TareaBO tareaDtoToBo(TareaDTO tareaDto ) {
		
		return modelMapper.map(tareaDto, TareaBO.class);
	}

}
