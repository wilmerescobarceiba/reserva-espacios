package com.ceiba.espacio.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;

@Getter
public class Espacio {
	private static final String SE_DEBE_INGRESAR_CODIGO = "Se debe ingresar el id de la categoría";
	private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el id del espacio";
	private static final String SE_DEBE_INGRESAR_DESCRIPCION = "Se debe ingresar el id de la categoría";
	private static final String SE_DEBE_INGRESAR_CAPACIDAD = "Se debe ingresar el id del espacio";
	private static final String SE_DEBE_INGRESAR_FOTOGRAFIA = "Se debe ingresar el id de la categoría";
	private static final String SE_DEBE_INGRESAR_COSTO = "Se debe ingresar el id del espacio";
	private static final String SE_DEBE_INGRESAR_ID_CATEGORIA = "Se debe ingresar el id del espacio";
	
	private Long id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Integer capacidad;
	private String fotografia;
	private Double costo;		
	private Long idcategoria;
	
	public Espacio(Long id, String codigo, String nombre, String descripcion, Integer capacidad, String fotografia,
			Double costo, Long idcategoria) {
		validarObligatorio(codigo, SE_DEBE_INGRESAR_CODIGO);
		validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE);
		validarObligatorio(descripcion, SE_DEBE_INGRESAR_DESCRIPCION);
		validarObligatorio(capacidad, SE_DEBE_INGRESAR_CAPACIDAD);
		validarObligatorio(fotografia, SE_DEBE_INGRESAR_FOTOGRAFIA);
		validarObligatorio(costo, SE_DEBE_INGRESAR_COSTO);
		validarObligatorio(idcategoria, SE_DEBE_INGRESAR_ID_CATEGORIA);
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.fotografia = fotografia;
		this.costo = costo;
		this.idcategoria = idcategoria;
	}
	
	
}
