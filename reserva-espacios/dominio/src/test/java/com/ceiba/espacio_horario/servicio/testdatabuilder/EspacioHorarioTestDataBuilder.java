package com.ceiba.espacio_horario.servicio.testdatabuilder;

import com.ceiba.espacio_horario.modelo.entidad.EspacioHorario;

public class EspacioHorarioTestDataBuilder {

	private Long id;
	private Long idhorario;
	private Long idespacio;

	public EspacioHorarioTestDataBuilder() {
		idespacio = 1l;
		idhorario = 1l;
	}

	public EspacioHorarioTestDataBuilder conIdEspacio(Long idespacio) {
		this.idespacio = idespacio;
		return this;
	}

	public EspacioHorarioTestDataBuilder conHorario(Long idhorario) {
		this.idhorario = idhorario;
		return this;
	}

	public EspacioHorarioTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public EspacioHorario build() {
		return new EspacioHorario(id, idhorario, idespacio);
	}
}
