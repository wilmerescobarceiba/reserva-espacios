package com.ceiba.categoria.servicio.testdatabuilder;

import com.ceiba.categoria.comando.ComandoCategoria;

public class ComandoCategoriaTestDataBuilder {

	private Long id;
	private String codigo;
	private String nombre;
	private String fotografia;

	public ComandoCategoriaTestDataBuilder() {
		codigo = "123456";
		nombre = "Recreación";
		fotografia = "base64...";
	}

	public ComandoCategoria build() {
		return new ComandoCategoria(id, codigo, nombre, fotografia);
	}
}
