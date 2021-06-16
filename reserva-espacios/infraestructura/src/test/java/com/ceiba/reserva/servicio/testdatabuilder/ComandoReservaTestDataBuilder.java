package com.ceiba.reserva.servicio.testdatabuilder;


import java.util.Date;

import com.ceiba.reserva.comando.ComandoReserva;

public class ComandoReservaTestDataBuilder {

	private Long id;
	private Date fecha;
	private Long idaliado;
	private Long idespacio;
	private Double costototal;
	private Long idhorario;

	public ComandoReservaTestDataBuilder() {		
		fecha = new Date();
		idaliado = 1l;
		idespacio = 1l;
		costototal = 0d;
		idhorario = 1l;
	}

	/*public ComandoReservaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}*/

	public ComandoReserva build() {
		return new ComandoReserva(id, fecha, idaliado, idespacio, costototal, idhorario);
	}
}
