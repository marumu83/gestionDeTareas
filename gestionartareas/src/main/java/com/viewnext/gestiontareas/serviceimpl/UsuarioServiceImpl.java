package com.viewnext.gestiontareas.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viewnext.gestiontareas.persistence.repository.UsuarioRepositorio;
import com.viewnext.gestiontareas.service.UsuarioService;
import com.viewnext.gestiontareas.service.bo.UsuarioBO;

import lombok.AllArgsConstructor;


/**
 * Clase que implementa los metodos abstractos de la 
 * clase UsuarioService
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */


@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	/**
	 * instancia de la clase Usuariorepositorio
	 */
	private final UsuarioRepositorio repositorio;
	
	/**
	 * Instancia de la clase BoToEntity
	 */
	
	private final BoToEntity boToEntity;
	
	/**
	 * Instancia de la clase EntityToBo
	 */
	private final EntityToBo entityToBo;

	/**
	 * Metodo que inserta un UsuarioBO en la base de datos
	 * @param UsuarioBO usuarioBo
	 * @return UsuarioBo
	 */
	@Override
	public UsuarioBO insert(UsuarioBO usuarioBo) {
		
		return entityToBo.usuarioEntityToBo(repositorio.save(boToEntity.usuarioBoToEntity(usuarioBo)));

	}
	/**
	 * Metodo que borra un usuario de la base de datos
	 * buscandolo por id
	 * @param int id
	 */

	@Override
	public void deleteUsuario(int id) {
		
		repositorio.deleteById(id);
		
	}

	/**
	 * Metodo que actualiza un UsuarioBO de la base de datos
	 * @param UsuarioBO usuarioBo
	 * @return UsuarioBo usuarioBo actualizado
	 */
	@Override
	public UsuarioBO update(UsuarioBO usuarioBO) {

		UsuarioBO usuarioBo2 = entityToBo.usuarioEntityToBo(repositorio.findById(usuarioBO.getId()).orElse(null));
		usuarioBo2.setId(usuarioBO.getId());
		usuarioBo2.setEmail(usuarioBO.getEmail());
		usuarioBo2.setPassword(usuarioBO.getPassword());
		
		return entityToBo.usuarioEntityToBo(repositorio.save(boToEntity.usuarioBoToEntity(usuarioBo2)));
	}
	
	/**
	 * Meotodo que busca un usuario de la base de 
	 * datos por su id
	 * @param int id
	 */

	@Override
	public UsuarioBO findById(int id) {

		return entityToBo.usuarioEntityToBo(repositorio.findById(id).orElse(null));
	}
	
	/**
	 * Meotodo que devuelve una lista de todos los usuarios
	 * de la base de datos
	 * 
	 */

	@Override
	public List<UsuarioBO> findAll() {
		
		return repositorio.findAll().stream().map(entityToBo::usuarioEntityToBo).toList();
	}
	
	/**
	 * Meotodo que busca un usuario de la base de 
	 * datos por su nombre
	 * @param String nombre
	 */

	@Override
	public UsuarioBO findByNombre(String nombre) {

		return entityToBo.usuarioEntityToBo(repositorio.findByNombre(nombre));
	}
	
	/**
	 * Meotodo que busca un usuario de la base de 
	 * datos por su email
	 * @param String email
	 */

	@Override
	public UsuarioBO findByEmail(String email) {
		
		return entityToBo.usuarioEntityToBo(repositorio.findByEmail(email));
		
	}

}
