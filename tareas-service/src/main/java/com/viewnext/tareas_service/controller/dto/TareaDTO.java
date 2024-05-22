package com.viewnext.tareas_service.controller.dto;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase tarea objeto de transferencia de datos DTO
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaDTO {

    private int id;

    private String titulo;

    private Date fechaAlta;

    private Date fechaFin;

    private Date ultimaModificacion;

    private String descripcion;

    private boolean finalizada;

}