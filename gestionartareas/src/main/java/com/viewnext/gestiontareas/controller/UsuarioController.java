package com.viewnext.gestiontareas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.gestiontareas.controller.dto.UsuarioDTO;
import com.viewnext.gestiontareas.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	private final BoToDto boToDto;
	
	private final DtoToBo dtoToBo;
	
	public UsuarioController(UsuarioService usuarioService, BoToDto boToDto, DtoToBo dtoToBo) {
		this.usuarioService= usuarioService;
		this.boToDto= boToDto;
		this.dtoToBo= dtoToBo;
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<UsuarioDTO>  createUser(@RequestBody UsuarioDTO usuarioDTO, HttpServletRequest request){
		
		usuarioService.insert(dtoToBo.usuarioDtoToBo(usuarioDTO));
		
		return ResponseEntity.ok(usuarioDTO);
	}

}
