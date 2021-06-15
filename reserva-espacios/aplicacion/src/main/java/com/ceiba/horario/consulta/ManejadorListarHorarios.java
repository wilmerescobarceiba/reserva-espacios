package com.ceiba.horario.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.puerto.dao.DaoHorario;

@Component
public class ManejadorListarHorarios {

	private final DaoHorario daoHorario;

	public ManejadorListarHorarios(DaoHorario daoHorario) {
		this.daoHorario = daoHorario;
	}

	public List<DtoHorario> ejecutar() {
		return this.daoHorario.listar();
	}
}