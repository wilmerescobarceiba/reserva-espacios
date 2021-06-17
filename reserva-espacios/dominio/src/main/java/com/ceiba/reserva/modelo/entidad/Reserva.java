package com.ceiba.reserva.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reserva {
	private static final String SE_DEBE_INGRESAR_FECHA = "Se debe ingresar una fecha";
	private static final String SE_DEBE_INGRESAR_ID_ALIADO = "Se debe ingresar el id del aliado";
	private static final String SE_DEBE_INGRESAR_ID_ESPACIO = "Se debe ingresar el id del espacio";
	private static final String SE_DEBE_INGRESAR_ID_HORARIO = "Se debe ingresar el id del horario";

	private Long id;
	private Date fecha;
	private Long idaliado;
	private Long idespacio;
	private Double costototal;
	private Long idhorario;
	
public Reserva(){}
	public Reserva(Long id, Date fecha, Long idaliado, Long idespacio, Double costototal, Long idhorario) {
		validarObligatorio(fecha, SE_DEBE_INGRESAR_FECHA);
		validarObligatorio(idaliado, SE_DEBE_INGRESAR_ID_ALIADO);
		validarObligatorio(idespacio, SE_DEBE_INGRESAR_ID_ESPACIO);
		validarObligatorio(idhorario, SE_DEBE_INGRESAR_ID_HORARIO);

		this.id = id;
		this.fecha = fecha;
		this.idaliado = idaliado;
		this.idespacio = idespacio;
		this.idhorario = idhorario;
		
		this.costototal = costototal;
	}

}
