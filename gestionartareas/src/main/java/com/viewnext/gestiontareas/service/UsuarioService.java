package com.viewnext.gestiontareas.service;

import java.util.List;

import com.viewnext.gestiontareas.service.bo.UsuarioBO;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
public interface UsuarioService{
	
	UsuarioBO insert(UsuarioBO usuarioBo);
	
	void deleteUsuario(int id);
	
	UsuarioBO update (UsuarioBO usuarioBO);
	
	UsuarioBO findById(int id);
	
	List<UsuarioBO> findAll();

}
