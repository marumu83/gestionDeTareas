package com.viewnext.gestiontareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.gestiontareas.persistence.model.Tarea;
import com.viewnext.gestiontareas.service.TareaService;

/**
 * Clase que gestiona las peticiones REST de la clase Tarea
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Controller
@RequestMapping("/tarea")
public class TareaController {
	
	@Autowired
	private TareaService tareaService;
	
	@GetMapping("/holamundo")
	public String prueba() {
		return "HolaMundo";
	}
	
	
	@GetMapping("/all")
	public List<Tarea> getAll(){
		return tareaService.finAll();
	}
	
	

}
