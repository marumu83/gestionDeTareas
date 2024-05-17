package com.viewnext.gestiontareas.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	
	private String jwt;

}
