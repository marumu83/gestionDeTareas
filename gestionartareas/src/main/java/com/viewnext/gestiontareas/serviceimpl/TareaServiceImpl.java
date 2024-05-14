package com.viewnext.gestiontareas.serviceimpl;

import java.util.List;
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
	

	private final TareaRepository tareaRepository;


	private final BoToEntity boToEntity;
	
	
	private final  EntityToBo entityToBo;
	
	/**
	 * Constructor parametrizado que inyecta e inicializa las dependencias
	 * @param tareaRepository
	 * @param boToEntity
	 * @param entityToBo
	 * 
	 */
	
	public TareaServiceImpl(TareaRepository tareaRepository, BoToEntity boToEntity,EntityToBo entityToBo) {
		
		this.tareaRepository = tareaRepository;
		this.boToEntity = boToEntity;
		this.entityToBo = entityToBo;
	}
	
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
	public void deleteTarea(int id) {
		
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
       
        TareaBO tareaBo2 = entityToBo.tareaEntityToBo(tareaRepository.findById(tareaBo.getId()).orElse(null));
     
       
        tareaBo2.setDescripcion(tareaBo.getDescripcion());
        tareaBo2.setFechaFin(tareaBo.getFechaFin());
        tareaBo2.setTitulo(tareaBo.getTitulo());
        tareaBo2.setUltimaModificacion(tareaBo.getUltimaModificacion());
        tareaBo2.setFinalizada(tareaBo.isFinalizada());
       
        return entityToBo.tareaEntityToBo(tareaRepository.save(boToEntity.tareaBoToEntity(tareaBo2)));
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
		
		
		return tareaRepository.findAll().stream().map(entityToBo::tareaEntityToBo).toList();
	}
}