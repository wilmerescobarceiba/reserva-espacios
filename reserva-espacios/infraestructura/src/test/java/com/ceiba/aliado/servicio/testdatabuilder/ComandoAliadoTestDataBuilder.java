package com.ceiba.aliado.servicio.testdatabuilder;

import java.util.UUID;

import com.ceiba.aliado.comando.ComandoAliado;

public class ComandoAliadoTestDataBuilder {

	private Long id;
	private String nombre;
	private String nit;

	public ComandoAliadoTestDataBuilder() {
		nit = UUID.randomUUID().toString();
		nombre = UUID.randomUUID().toString();
	}

	public ComandoAliado build() {
		return new ComandoAliado(id, nit, nombre);
	}
}
