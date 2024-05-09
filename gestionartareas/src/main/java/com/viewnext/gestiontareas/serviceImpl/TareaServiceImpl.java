package com.viewnext.gestiontareas.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.gestiontareas.persistence.model.Tarea;
import com.viewnext.gestiontareas.persistence.repository.TareaRepository;
import com.viewnext.gestiontareas.service.TareaService;
import com.viewnext.gestiontareas.service.bo.TareaBO;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 * Clase que desarrolla los metodos de la interfaz TareaService
 *
 */

@Service
public class TareaServiceImpl implements TareaService {
	
	@Autowired
	TareaRepository tareaRepository;

	@Autowired
	private BoToEntity boToEntity;
	
	@Autowired
	private EntityToBo entityToBo;
	
	/**
	 * Metodo que inserta una TareaBO en la base de datos
	 * @param TareaBO tareaBo
	 * @return Tarea
	 * 
	 */
	@Override
	public TareaBO insert(TareaBO tareaBo) {
	
		return entityToBo.tareaEntityToBo(tareaRepository.save(boToEntity.tareaBoToEntity(tareaBo)));
		
	}

	/**
	 * Metodo que borra una Tarea de la base de datos
	 * 
	 */
	
	@Override
	public void delete(int id) {
		
		Tarea tarea = tareaRepository.findById(id).orElse(null);
		
		tareaRepository.delete(tarea);

	}
	
	/**
	 * Metodo que actualiza una Tarea de la base de datos
	 * @param TareaBO tareaBo
	 * @return Tarea tarea
	 */

	@Override
	public TareaBO update(TareaBO tareaBo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Metodo que busca una tarea de la base de datos por id
	 * @param int id
	 * @return Tarea tarea
	 * 
	 */

	@Override
	public TareaBO findById(int id) {		
		
		return entityToBo.tareaEntityToBo(tareaRepository.findById(id).orElse(null));
	}
	
	/**
	 * Metodo que devuelve una lista de todas las tareas
	 * @return List TareaBO
	 */

	@Override
	public List<TareaBO> finAll() {		
		
		List<Tarea> temp = tareaRepository.findAll();
		System.out.println("lista tarea" +temp);
		
		return tareaRepository.findAll().stream().map(entityToBo::tareaEntityToBo).collect(Collectors.toList());
	}
}