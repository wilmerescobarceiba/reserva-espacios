package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva{
	private Long id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;			
	private Long idaliado;		
	private Long idespacio;
	private Double costototal;
	private Long idhorario;

	public void setFecha(String fecha) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		this.fecha = formatter.parse(fecha);
	}
}
