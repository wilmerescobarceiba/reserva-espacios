package com.ceiba.reserva.comando;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva{
	private Long id;	
	private Date fecha;			
	private Long idaliado;		
	private Long idespacio;
	private Double costototal;
	private Long idhorario;

}
