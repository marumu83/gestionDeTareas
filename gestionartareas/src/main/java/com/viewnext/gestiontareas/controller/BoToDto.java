package com.viewnext.gestiontareas.controller;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.viewnext.gestiontareas.controller.dto.TareaDTO;
import com.viewnext.gestiontareas.controller.dto.UsuarioDTO;
import com.viewnext.gestiontareas.service.bo.TareaBO;
import com.viewnext.gestiontareas.service.bo.UsuarioBO;

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
	public UsuarioDTO usuarioBoToDto(UsuarioBO usuarioBO) {
		
		return modelMapper.map(usuarioBO, UsuarioDTO.class);
	}

}
