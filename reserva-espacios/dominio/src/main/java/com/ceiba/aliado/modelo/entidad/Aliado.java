package com.ceiba.aliado.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;

@Getter
public class Aliado {
	private static final String SE_DEBE_INGRESAR_NIT = "Se debe ingresar el NIT";
	private static final String SE_DEBE_INGRESAR_NOMBRES = "Se debe ingresar los nombres";

	private Long id;
	private String nit;
	private String nombre;

	public Aliado(Long id, String nit, String nombre) {

		validarObligatorio(nit, SE_DEBE_INGRESAR_NIT);
		validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRES);

		this.id = id;
		this.nit = nit;
		this.nombre = nombre;
	}
	
	
}
