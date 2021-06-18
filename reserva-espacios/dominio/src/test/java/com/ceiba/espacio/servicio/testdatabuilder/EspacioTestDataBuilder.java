package com.ceiba.espacio.servicio.testdatabuilder;

import com.ceiba.espacio.modelo.entidad.Espacio;

public class EspacioTestDataBuilder {

	private Long id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Integer capacidad;
	private String fotografia;
	private Double costo;
	private Long idcategoria;

	public EspacioTestDataBuilder() {
		codigo = "espacio-01";
		nombre = "Espacio recreacion";
		descripcion = "Esta es la descripcion";
		capacidad = 0;
		fotografia = "base64...";
		costo = 10000d;
		idcategoria = 1l;
	}

	public EspacioTestDataBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public EspacioTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public EspacioTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public Espacio build() {
		return new Espacio(id, codigo, nombre, descripcion, capacidad, fotografia, costo, idcategoria);
	}
}
