package com.viewnext.usuarios_service.controller;

import com.viewnext.usuarios_service.controller.dto.AuthenticationRequest;
import com.viewnext.usuarios_service.controller.dto.AuthenticationResponse;
import com.viewnext.usuarios_service.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/prueba")
    public String prueba() {

        return "Estas en zona publica";
    }

}