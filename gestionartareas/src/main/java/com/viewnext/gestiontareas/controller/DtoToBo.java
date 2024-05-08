package com.viewnext.gestiontareas.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	ModelMapper modelMapper;
	
	public TareaBO tareaDtoToBo(TareaDTO tareaDto ) {
		
		return modelMapper.map(tareaDto, TareaBO.class);
	}

}