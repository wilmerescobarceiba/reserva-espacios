package com.ceiba.horario.comando;

import com.ceiba.horario.comando.type.HoraType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoHorario{

	private Long id;
	private HoraType hora;
}
