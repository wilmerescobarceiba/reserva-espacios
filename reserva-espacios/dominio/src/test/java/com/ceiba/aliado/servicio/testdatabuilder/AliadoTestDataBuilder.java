package com.ceiba.aliado.servicio.testdatabuilder;

import com.ceiba.aliado.modelo.entidad.Aliado;

public class AliadoTestDataBuilder {

	private Long id;
	private String nombre;
	private String nit;

	public AliadoTestDataBuilder() {
		nit = "123456789";
		nombre = "Acme S.A.S";
	}

	public AliadoTestDataBuilder conNit(String nit) {
		this.nit = nit;
		return this;
	}

	public AliadoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public AliadoTestDataBuilder conNombre(Long id) {
		this.id = id;
		return this;
	}

	public Aliado build() {
		return new Aliado(id, nit, nombre);
	}
}
