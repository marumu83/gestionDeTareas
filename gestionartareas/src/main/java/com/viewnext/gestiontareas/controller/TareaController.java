package com.viewnext.gestiontareas.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viewnext.gestiontareas.controller.dto.TareaDTO;
import com.viewnext.gestiontareas.service.TareaService;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Clase que gestiona las peticiones REST de la clase Tarea
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */


@RestController
@RequestMapping("/api/tareas")
public class TareaController {
	
	/**
	 * Instancia de la clase Tareaservice para llamar a
	 * los metodos necesarios
	 */
	
	private final TareaService tareaService;
		
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
	 * Constructor parametrizado que iyecta las instancias 
	 * necesarias para responder a los endpoints
	 * @param tareaService
	 * @param boToDto
	 * @param dtoToBo
	 */
	
	public TareaController(TareaService tareaService, BoToDto boToDto, DtoToBo dtoToBo) {
		this.tareaService=tareaService;
		this.boToDto=boToDto;
		this.dtoToBo=dtoToBo;
	}
	
	/**
	 * Metodo publico que crea una nueva tarea, y devuelve la
	 * tarea creada si se ha creado correctamente. 
	 * @param TareaDTO tarea
	 * @param request
	 * @return ResponseEntity
	 */
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/nueva")
	public ResponseEntity <TareaDTO> createTarea(@RequestBody TareaDTO tarea, HttpServletRequest request){
	
		tareaService.insert(dtoToBo.tareaDtoToBo(tarea));
		return ResponseEntity.ok(tarea);
	}
	
	/**
	 * Metodo publico que devuelve una lista de todas las tareas
	 * registradas en la base de datos
	 * @return List
	 */
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/all")
	public List<TareaDTO> getAll() {
		
		return tareaService.findAll().stream()
		        .map(boToDto::tareaBoToDto).toList();

	}
	
	/**
	 * Metodo publico que devuelve una TareaDTO que es buscada
	 * por su identificador en la base datos
	 * @param id
	 * @return TareaDTO
	 */
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/id/{id}")	
	public TareaDTO getById(@PathVariable("id") int id){		

		return boToDto.tareaBoToDto(tareaService.findById(id));

	}
	
	
	/**
	 * Metodo publico que elimina una tarea de la base de datos
	 * localizada por su id
	 * @param int id
	 */
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/eliminar/{id}")
	public void deleteTarea(@PathVariable int id) {
		
		tareaService.deleteTarea(id);
	}
	
	/**
	 * Metodo publico que actualiza una tarea
	 * @param TareaDTO tareaDTO  
	 * @return TareaDTO 
	 */

	@PreAuthorize("hasRole('ROLE_USER')")
	@PutMapping("/update")
    public TareaDTO updateById(@RequestBody TareaDTO tareaDTO) {
				
        return boToDto.tareaBoToDto(tareaService.update(dtoToBo.tareaDtoToBo(tareaDTO)));
    }

	
}
