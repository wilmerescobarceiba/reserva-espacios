package com.ceiba.espacio.servicio.testdatabuilder;

import com.ceiba.espacio.comando.ComandoEspacio;

public class ComandoEspacioTestDataBuilder {

	private Long id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Integer capacidad;
	private String fotografia;
	private Double costo;
	private Long idcategoria;

	public ComandoEspacioTestDataBuilder() {
		codigo = "espacio-01";
		nombre = "Espacio recreacion";
		descripcion = "Esta es la descripcion";
		capacidad = 0;
		fotografia = "base64...";
		costo = 10000d;
		idcategoria = 1l;
	}

	public ComandoEspacio build() {		
		return new ComandoEspacio(id, codigo, nombre, descripcion, capacidad, costo, fotografia, idcategoria);
	}
}
