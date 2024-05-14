package com.viewnext.gestiontareas.controller;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viewnext.gestiontareas.controller.dto.TareaDTO;
import com.viewnext.gestiontareas.service.TareaService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


/**
 * Clase que gestiona las peticiones REST de la clase Tarea
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */


@RestController
@RequestMapping("/api/tareas")
public class TareaController {
	
	
	private TareaService tareaService;
	
	
	private BoToDto boToDto;
	
	
	private DtoToBo dtoToBo;
	
	public TareaController(TareaService tareaService, BoToDto boToDto, DtoToBo dtoToBo) {
		this.tareaService=tareaService;
		this.boToDto=boToDto;
		this.dtoToBo=dtoToBo;
	}
	
	
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
		        .map(boToDto::tareaBoToDto).toList();

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
	
	
	@PutMapping("/update")
    public TareaDTO updateById(@RequestBody TareaDTO tareaDTO) {
		
		System.out.println("Provando en controler"+tareaDTO);
		
        return boToDto.tareaBoToDto(tareaService.update(dtoToBo.tareaDtoToBo(tareaDTO)));
    }
	
}
