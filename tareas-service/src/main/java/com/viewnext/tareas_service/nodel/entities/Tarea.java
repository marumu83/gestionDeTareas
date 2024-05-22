package com.viewnext.tareas_service.nodel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tarea")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private Date fechaAlta;

    private Date fechaFin;

    private Date ultimaModificacion;

    private String descripcion;

    private boolean finalizada;

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", fechaFin=" + fechaFin +
                ", ultimaModificacion=" + ultimaModificacion +
                ", descripcion='" + descripcion + '\'' +
                ", finalizada=" + finalizada +
                '}';
    }
}
