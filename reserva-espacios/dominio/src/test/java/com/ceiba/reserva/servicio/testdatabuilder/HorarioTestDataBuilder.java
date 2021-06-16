package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.horario.modelo.entidad.Horario;

public class HorarioTestDataBuilder {

	private Long id;
	private String hora;

	public HorarioTestDataBuilder() {
		hora = HoraType.H01_02.value;
	}

	public HorarioTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public HorarioTestDataBuilder conHora(String hora) {
		this.hora = hora;
		return this;
	}

	public Horario build() {
		return new Horario(id, hora);
	}
}
