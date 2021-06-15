package com.ceiba.espacio_horario.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;

@Getter
public class EspacioHorario {
	
	private static final String SE_DEBE_INGRESAR_ID_HORARIO = "Se debe ingresar el id del horario";
	private static final String SE_DEBE_INGRESAR_ID_ESPACIO = "Se debe ingresar el id del espacio";

	private Long id;
	private Long idhorario;
	private Long idespacio;

	public EspacioHorario(Long id, Long idhorario, Long idespacio) {
		validarObligatorio(idhorario, SE_DEBE_INGRESAR_ID_HORARIO);
		validarObligatorio(idespacio, SE_DEBE_INGRESAR_ID_ESPACIO);
		this.id = id;
		this.idhorario = idhorario;
		this.idespacio = idespacio;
	}
	
}
