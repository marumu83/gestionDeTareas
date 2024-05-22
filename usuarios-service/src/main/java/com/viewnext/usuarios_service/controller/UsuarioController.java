package com.viewnext.usuarios_service.controller;

import java.util.List;

import com.viewnext.usuarios_service.controller.dto.UsuarioDTO;
import com.viewnext.usuarios_service.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.servlet.http.HttpServletRequest;

/**
 * Clase que gestiona las peticiones REST de la clase usuario
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Instancia de la clase UsuarioService para llamar a
     * los metodos necesarios
     */
    private final UsuarioService usuarioService;


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
     * Constructor parametrizado que inyecta las instancias
     * necesarias para responder a los endpoints
     * @param usuarioService
     * @param boToDto
     * @param dtoToBo
     */

    public UsuarioController(UsuarioService usuarioService, BoToDto boToDto, DtoToBo dtoToBo) {
        this.usuarioService= usuarioService;
        this.boToDto= boToDto;
        this.dtoToBo= dtoToBo;
    }

    /**
     * Metodo publico para la creacion de un nuevo usuario
     * @param usuarioDTO
     * @param request
     * @return ResponseEntity
     */

    @PostMapping("/nuevo")
    public ResponseEntity<UsuarioDTO>  createUser(@RequestBody UsuarioDTO usuarioDTO, HttpServletRequest request){

        usuarioDTO.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));

        usuarioService.insert(dtoToBo.usuarioDtoToBo(usuarioDTO));

        return ResponseEntity.ok(usuarioDTO);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all")
    public List<UsuarioDTO> getAll(){

        return usuarioService.findAll().stream().map(boToDto::usuarioBoToDto).toList();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/nombre/{nombre}")
    public UsuarioDTO getByName(@PathVariable ("nombre") String nombre) {

        return boToDto.usuarioBoToDto(usuarioService.findByNombre(nombre));
    }

    /**
     * Meotodo que busca un usuario de la base de
     * datos por su email
     * @param String email
     * @
     */

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/email/{email}")
    public UsuarioDTO getByEmail(@PathVariable ("email") String email) {

        return boToDto.usuarioBoToDto(usuarioService.findByNombre(email));
    }

}