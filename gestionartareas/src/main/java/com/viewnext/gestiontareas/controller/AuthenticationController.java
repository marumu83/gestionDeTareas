package com.viewnext.gestiontareas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.gestiontareas.controller.dto.AuthenticationRequest;
import com.viewnext.gestiontareas.controller.dto.AuthenticationResponse;
import com.viewnext.gestiontareas.serviceimpl.AuthenticationService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(
			@RequestBody @Valid AuthenticationRequest authRequest) {

		AuthenticationResponse jwtDto = authenticationService.login(authRequest);
		
		return ResponseEntity.ok(jwtDto);
	}
	
	
	

}
