package com.ceiba.reserva.modelo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoReserva {

	private Long id;
	private Date fecha;
	private Long idaliado;
	private Long idespacio;
	private Double costototal;
	private Long idhorario;

}
