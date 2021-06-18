package com.ceiba.reserva.modelo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoReserva {

	private Long id;
	private Date fecha;
	private Long idaliado;
	private Long idespacio;
	private Double costototal;
	private Long idhorario;

}
