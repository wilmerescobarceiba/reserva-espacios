package com.ceiba.reserva.servicio.testdatabuilder;

import java.util.Date;

import com.ceiba.reserva.modelo.entidad.Reserva;

public class ReservaTestDataBuilder {

	private Long id;
	private Date fecha;
	private Long idaliado;
	private Long idespacio;
	private Double costototal;
	private Long idhorario;

	public ReservaTestDataBuilder() {
		fecha = new Date();		
		idaliado = 1l;
		idespacio = 1l;
		costototal = 0d;
		idhorario = 1l;
	}

	public ReservaTestDataBuilder conAliado(Long idaliado) {
		this.idaliado = idaliado;
		return this;
	}

	public ReservaTestDataBuilder conEspacio(Long idespacio) {
		this.idespacio = idespacio;
		return this;
	}

	public ReservaTestDataBuilder conHorario(Long idhorario) {
		this.idhorario = idhorario;
		return this;
	}

	public ReservaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public Reserva build() {
		return new Reserva(id, fecha, idaliado, idespacio, costototal, idhorario);
	}
}
