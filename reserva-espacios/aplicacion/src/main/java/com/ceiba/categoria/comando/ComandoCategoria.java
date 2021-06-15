package com.ceiba.categoria.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCategoria{

	private Long id;
	private String codigo;
	private String nombre;
	private String fotografia;
}
