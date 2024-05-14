package com.viewnext.gestiontareas.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viewnext.gestiontareas.persistence.repository.UsuarioRepositorio;
import com.viewnext.gestiontareas.service.UsuarioService;
import com.viewnext.gestiontareas.service.bo.UsuarioBO;

import lombok.AllArgsConstructor;


/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */


@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepositorio repositorio;
	
	private final BoToEntity boToEntity;
	
	private final EntityToBo entityToBo;

	@Override
	public UsuarioBO insert(UsuarioBO usuarioBo) {
		
		return entityToBo.usuarioEntityToBo(repositorio.save(boToEntity.usuarioBoToEntity(usuarioBo)));

	}

	@Override
	public void deleteUsuario(int id) {
		
		repositorio.deleteById(id);
		
	}

	@Override
	public UsuarioBO update(UsuarioBO usuarioBO) {

		UsuarioBO usuarioBo2 = entityToBo.usuarioEntityToBo(repositorio.findById(usuarioBO.getId()).orElse(null));
		usuarioBo2.setId(usuarioBO.getId());
		usuarioBo2.setEmail(usuarioBO.getEmail());
		usuarioBo2.setPassword(usuarioBO.getPassword());
		
		return entityToBo.usuarioEntityToBo(repositorio.save(boToEntity.usuarioBoToEntity(usuarioBo2)));
	}

	@Override
	public UsuarioBO findById(int id) {

		return entityToBo.usuarioEntityToBo(repositorio.findById(id).orElse(null));
	}

	@Override
	public List<UsuarioBO> findAll() {
		
		return repositorio.findAll().stream().map(entityToBo::usuarioEntityToBo).toList();
	}

}
