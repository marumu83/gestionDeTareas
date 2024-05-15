package com.viewnext.gestiontareas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.gestiontareas.controller.dto.UsuarioDTO;
import com.viewnext.gestiontareas.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Clase que gestiona las peticiones REST de la clase usuario
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	/**
	 * Instancia de la clase UsuarioService para llamar a
	 * los metodos necesarios
	 */
	private final UsuarioService usuarioService;
	
	
	/**
	 * Instancia de la clase mapeador de objeto
	 * de negocio a objeto de transferencia de datos 
	 */
	
	private final BoToDto boToDto;
	
	/**
	 * Instancia de la clase mapeadora de objeto de
	 * transferencia de datos a objeto de negocio
	 */
	
	private final DtoToBo dtoToBo;
	
	
	/**
	 * Constructor parametrizado que inyecta las instancias
	 * necesarias para responder a los endpoints
	 * @param usuarioService
	 * @param boToDto
	 * @param dtoToBo
	 */
	
	public UsuarioController(UsuarioService usuarioService, BoToDto boToDto, DtoToBo dtoToBo) {
		this.usuarioService= usuarioService;
		this.boToDto= boToDto;
		this.dtoToBo= dtoToBo;
	}
	
	/**
	 * Metodo publico para la creacion de un nuevo usuario
	 * @param usuarioDTO
	 * @param request
	 * @return ResponseEntity
	 */
	
	@PostMapping("/nuevo")
	public ResponseEntity<UsuarioDTO>  createUser(@RequestBody UsuarioDTO usuarioDTO, HttpServletRequest request){
		
		usuarioService.insert(dtoToBo.usuarioDtoToBo(usuarioDTO));
		
		return ResponseEntity.ok(usuarioDTO);
	}

}
