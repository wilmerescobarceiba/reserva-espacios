package com.ceiba.horario.servicio.testdatabuilder;

import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.comando.type.HoraType;

public class ComandoHorarioTestDataBuilder {

	private Long id;
	private HoraType hora;

	public ComandoHorarioTestDataBuilder() {
		hora = HoraType.H01_02;
	}

	public ComandoHorario build() {
		return new ComandoHorario(id, hora);
	}
}
