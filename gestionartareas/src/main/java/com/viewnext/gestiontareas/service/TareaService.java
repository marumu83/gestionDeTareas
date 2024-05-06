package com.viewnext.gestiontareas.service;

import java.util.List;

import com.viewnext.gestiontareas.persistence.model.Tarea;
import com.viewnext.gestiontareas.service.bo.TareaBO;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
public interface TareaService {
	
	Tarea insert (TareaBO tareaBo);
	
	void delete ();
	
	Tarea update (TareaBO tareaBo);
	
	Tarea findById(int id);
	
	List<Tarea> finAll();

}
