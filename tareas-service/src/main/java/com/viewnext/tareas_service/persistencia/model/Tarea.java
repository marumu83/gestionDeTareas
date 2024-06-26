package com.viewnext.tareas_service.persistencia.model;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que reprensenta le entidad Tarea de la base de datos
 * @author Manuel Rubio
 * @author Javier Garrido
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Tarea{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private Date fechaAlta;

    private Date fechaFin;

    private Date ultimaModificacion;

    private String descripcion;

    private boolean finalizada;
}