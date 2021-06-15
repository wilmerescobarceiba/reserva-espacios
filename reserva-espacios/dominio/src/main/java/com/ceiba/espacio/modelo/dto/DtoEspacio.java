package com.ceiba.espacio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoEspacio {
	
	private Long id;	
	private String codigo;
	private String nombre;
	private String descripcion;
	private Integer capacidad;
	private Double costo;
	private String fotografia;
	private Long idcategoria;
	
}
