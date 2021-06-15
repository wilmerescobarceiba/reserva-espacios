package com.ceiba.espacio_horario.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.espacio_horario.comando.ComandoEspacioHorario;
import com.ceiba.espacio_horario.modelo.entidad.EspacioHorario;

@Component
public class FabricaEspacioHorario {

	public EspacioHorario crear(ComandoEspacioHorario comandoEspacioHorario) {
		return new EspacioHorario(comandoEspacioHorario.getId(), comandoEspacioHorario.getIdhorario(),
				comandoEspacioHorario.getIdespacio());
	}

}
