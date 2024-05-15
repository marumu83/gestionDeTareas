package com.viewnext.gestiontareas.controller;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.viewnext.gestiontareas.controller.dto.TareaDTO;
import com.viewnext.gestiontareas.controller.dto.UsuarioDTO;
import com.viewnext.gestiontareas.service.bo.TareaBO;
import com.viewnext.gestiontareas.service.bo.UsuarioBO;

/**
 * Metodo que mapea objetos de transferencia de datos DTO
 * a objetos de negocio BO
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Configuration
public class DtoToBo {
	
	/**
	 * Instancia de la clase ModelMapper para
	 * el mapeo automatico de los objetos
	 */
	
	private final ModelMapper modelMapper;
	
	/**
	 * Constructor parametrizado que inyecta modelMapper
	 * @param modelMapper
	 */

	public DtoToBo(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	/**
	 * Metodo que recibe un objeto de negocio de tipo tarea 
	 * y devuelve un objeto tarea de transferencia de datos
	 * @param modelMapper
	 */
	
	public TareaBO tareaDtoToBo(TareaDTO tareaDto ) {
		
		return modelMapper.map(tareaDto, TareaBO.class);
	}
	
	/**
	 * Metodo que recibe un objeto de transferencia de datos DTOç
	 * de tipo usuario y devuelve un objeto usuario de negocio BO
	 * @param usuarioDto
	 * @return
	 */
	
	public UsuarioBO usuarioDtoToBo(UsuarioDTO usuarioDto) {
		
		return modelMapper.map(usuarioDto, UsuarioBO.class);
	}

}
