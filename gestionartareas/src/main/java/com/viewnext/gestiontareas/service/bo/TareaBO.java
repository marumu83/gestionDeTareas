package com.viewnext.gestiontareas.service.bo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase tarea de tipo objeto de negocio
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaBO {
	
	private int id;
	
	private String titulo;
	
	private Date fechaAlta;
	
	private Date fechaFin;
	
	private Date ultimaModificacion;	
	
	private String descripcion;
	
	private boolean finalizada;

}
