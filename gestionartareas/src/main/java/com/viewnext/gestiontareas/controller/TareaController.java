package com.viewnext.gestiontareas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.gestiontareas.persistence.model.Tarea;
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
	
	@Autowired
	private TareaService tareaService;
	
	
	/**
	 * Metodo inicial para comprobacion de inicio de aplicación
	 * @return String
	 */
	
	@GetMapping("/")	
	public String holaMundo(){
		
		System.out.println("entra");

		return "Esqueleto inicializado";

	}
	
	@PostMapping("/nueva")
	public ResponseEntity <Tarea> createUser(@RequestBody Tarea tarea, HttpServletRequest request){
		
		System.out.println(tarea);
		return ResponseEntity.ok(tarea);
	}
}
