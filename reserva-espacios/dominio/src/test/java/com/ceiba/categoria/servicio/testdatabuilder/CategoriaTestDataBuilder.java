package com.ceiba.categoria.servicio.testdatabuilder;

import com.ceiba.categoria.modelo.entidad.Categoria;

public class CategoriaTestDataBuilder {

	private Long id;
	private String codigo;
	private String nombre;
	private String fotografia;

	public CategoriaTestDataBuilder() {
		codigo = "123456";
		nombre = "Recreación";
		fotografia = "base64...";
	}

	public CategoriaTestDataBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public CategoriaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public CategoriaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public Categoria build() {
		return new Categoria(id, codigo, nombre, fotografia);
	}
}
