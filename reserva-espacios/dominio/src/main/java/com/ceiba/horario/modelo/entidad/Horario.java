package com.ceiba.horario.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;

@Getter
public class Horario {

	private static final String SE_DEBE_INGRESAR_HORA = "Se debe ingresar la hora";

	private Long id;

	private String hora;

	public Horario(Long id, String hora) {
		validarObligatorio(hora, SE_DEBE_INGRESAR_HORA);
		this.id = id;
		this.hora = hora;
	}

}
