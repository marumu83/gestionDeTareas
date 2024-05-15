package com.viewnext.gestiontareas.service.bo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase usuario de tipo objeto de negocio
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioBO {
	
	private int id;
	
	private String nombre;
	
	private String email;
	
	private String password;
}
