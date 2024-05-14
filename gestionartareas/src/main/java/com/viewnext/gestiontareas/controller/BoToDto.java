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
public class BoToDto {
	
	private final ModelMapper modelMapper;
	
	public BoToDto (ModelMapper modelMapper){
		this.modelMapper= modelMapper;
	}
	
	public TareaDTO tareaBoToDto(TareaBO tareaBo) {
		
		return modelMapper.map(tareaBo, TareaDTO.class);
		
	}

}
