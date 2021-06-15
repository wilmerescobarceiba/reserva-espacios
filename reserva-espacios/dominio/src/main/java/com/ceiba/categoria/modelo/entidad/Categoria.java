package com.ceiba.categoria.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;

@Getter
public class Categoria {
	
    private static final String SE_DEBE_INGRESAR_CODIGO = "Se debe ingresar el código";
    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar los nombre";
    private static final String SE_DEBE_INGRESAR_FOTOGRAFIA = "Se debe ingresar una fotografía";
	
	private Long id;
	private String codigo;
	private String nombre;
	private String fotografia;
	public Categoria(Long id, String codigo, String nombre, String fotografia) {
		validarObligatorio(codigo, SE_DEBE_INGRESAR_CODIGO);
		validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE);
		validarObligatorio(fotografia, SE_DEBE_INGRESAR_FOTOGRAFIA);
				
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.fotografia = fotografia;
	}
	
	
	
	
	
}
