package com.viewnext.usuarios_service.controller.dto;

import com.viewnext.usuarios_service.persistencia.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Clase usuario objeto de transferencia de datos DTO
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private int id;

    private String nombre;

    private String email;

    private String password;

    private Role role;
}