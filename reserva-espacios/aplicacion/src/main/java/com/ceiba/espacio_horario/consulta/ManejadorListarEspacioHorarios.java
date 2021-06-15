package com.ceiba.espacio_horario.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.espacio_horario.modelo.dto.DtoEspacioHorario;
import com.ceiba.espacio_horario.puerto.dao.DaoEspacioHorario;

@Component
public class ManejadorListarEspacioHorarios {

	private final DaoEspacioHorario daoEspacioHorario;

	public ManejadorListarEspacioHorarios(DaoEspacioHorario daoEspacioHorario) {
		this.daoEspacioHorario = daoEspacioHorario;
	}

	public List<DtoEspacioHorario> ejecutar() {
		return this.daoEspacioHorario.listar();
	}
}