package com.viewnext.usuarios_service.services;

import java.util.HashMap;
import java.util.Map;

import com.viewnext.usuarios_service.controller.dto.AuthenticationRequest;
import com.viewnext.usuarios_service.controller.dto.AuthenticationResponse;
import com.viewnext.usuarios_service.persistencia.model.Usuario;
import com.viewnext.usuarios_service.persistencia.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()
        );

        authenticationManager.authenticate(authenticationToken);

        Usuario usuario = usuarioRepositorio.findByNombre(authenticationRequest.getUsername());

        String jwt = jwtService.generateToken(usuario, generateExtraClaims(usuario));

        AuthenticationResponse jwtDto = new AuthenticationResponse(jwt);

        return jwtDto;


    }

    private Map<String, Object> generateExtraClaims(Usuario usuario){

        Map<String, Object> extraClaims = new HashMap<String, Object>();
        extraClaims.put("nombre", usuario.getNombre());
        extraClaims.put("role", usuario.getRole());
        extraClaims.put("permisions", usuario.getAuthorities());

        return extraClaims;
    }

}