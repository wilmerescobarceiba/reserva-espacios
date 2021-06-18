package com.ceiba.espacio_horario.servicio.testdatabuilder;

import com.ceiba.espacio_horario.comando.ComandoEspacioHorario;

public class ComandoEspacioHorarioTestDataBuilder {

	private Long id;
	private Long idespacio;
	private Long idhorario;

	public ComandoEspacioHorarioTestDataBuilder() {		
		idespacio = 1l;
		idhorario = 1l;
	}

	public ComandoEspacioHorario build() {		
		return new ComandoEspacioHorario(id, idhorario, idespacio);
	}
}
