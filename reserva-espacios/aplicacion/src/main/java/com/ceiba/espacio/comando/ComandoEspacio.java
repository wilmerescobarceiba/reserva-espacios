package com.ceiba.espacio.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEspacio{

	private Long id;	
	private String codigo;
	private String nombre;
	private String descripcion;
	private Integer capacidad;
	private Double costo;
	private String fotografia;
	private Long idcategoria;
}
