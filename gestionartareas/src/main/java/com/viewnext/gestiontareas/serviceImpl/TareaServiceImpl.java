package com.viewnext.gestiontareas.serviceImpl;

import java.util.List;

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

	/**
	 * Metodo que inserta una TareaBO en la base de datos
	 * @param TareaBO tareaBo
	 * @return Tarea
	 * 
	 */
	@Override
	public Tarea insert(TareaBO tareaBo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Metodo que borra una Tarea de la base de datos
	 * 
	 */
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Metodo que actualiza una Tarea de la base de datos
	 * @param TareaBO tareaBo
	 * @return Tarea tarea
	 */

	@Override
	public Tarea update(TareaBO tareaBo) {
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
	public Tarea findById(int id) {		
		
		return tareaRepository.findById(id).orElse(null);
	}
	
	/**
	 * Metodo que devuelve una lista de todas las tareas
	 * @return List TareaBO
	 */

	@Override
	public List<Tarea> finAll() {		
		
		return tareaRepository.findAll();
	}
}