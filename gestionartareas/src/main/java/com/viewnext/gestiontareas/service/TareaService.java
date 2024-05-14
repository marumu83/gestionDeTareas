package com.viewnext.gestiontareas.service;

import java.util.List;
import com.viewnext.gestiontareas.service.bo.TareaBO;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
public interface TareaService {
	
	TareaBO insert (TareaBO tareaBo);
	
	void deleteTarea (int id);
	
	TareaBO update (TareaBO tareaBo);
	
	TareaBO findById(int id);
	
	List<TareaBO> findAll();

}
