package com.viewnext.gestiontareas.controller;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.gestiontareas.controller.dto.TareaDTO;
import com.viewnext.gestiontareas.persistence.model.Tarea;
import com.viewnext.gestiontareas.service.TareaService;
import com.viewnext.gestiontareas.service.bo.TareaBO;

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
	
	@Autowired
	private TareaService tareaService;
	
	@Autowired
	private BoToDto boToDto;
	
	@Autowired
	private DtoToBo dtoToBo;
	
	
	@PostMapping("/nueva")
	public ResponseEntity <TareaDTO> createUser(@RequestBody TareaDTO tarea, HttpServletRequest request){
	
		tareaService.insert(dtoToBo.tareaDtoToBo(tarea));
		return ResponseEntity.ok(tarea);
	}
	
	/**
	 * Metodo que devuelve una lista con todos las tareas
	 * @return
	 */
	
	@GetMapping("/all")	
	public List<TareaDTO> getAll(){
	

		return tareaService.finAll().stream()
		        .map(boToDto::tareaBoToDto)
		        .collect(Collectors.toList());

	}
	
	/**
	 * Metodo para buscar tarea por id
	 * @param id
	 * @return
	 */
	
	@GetMapping("/id/{id}")	
	public TareaDTO getById(@PathVariable("id") int id){		

		return boToDto.tareaBoToDto(tareaService.findById(id));

	}
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteTarea(@PathVariable int id) {
		tareaService.deleteTarea(id);
	}
	
	@PutMapping("/update/{id}")
	public TareaDTO updateById(@RequestBody TareaDTO tareaDTO) {
		return boToDto.tareaBoToDto(tareaService.update(dtoToBo.tareaDtoToBo(tareaDTO)));
	}
	
}
