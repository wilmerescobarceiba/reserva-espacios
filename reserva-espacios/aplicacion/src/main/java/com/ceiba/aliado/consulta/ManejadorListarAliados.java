package com.ceiba.aliado.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.aliado.modelo.dto.DtoAliado;
import com.ceiba.aliado.puerto.dao.DaoAliado;

@Component
public class ManejadorListarAliados {

	private final DaoAliado daoAliado;

	public ManejadorListarAliados(DaoAliado daoAliado) {
		this.daoAliado = daoAliado;
	}

	public List<DtoAliado> ejecutar() {
		return this.daoAliado.listar();
	}
}