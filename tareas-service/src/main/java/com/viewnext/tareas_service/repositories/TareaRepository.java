package com.viewnext.tareas_service.repositories;

import com.viewnext.tareas_service.nodel.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
