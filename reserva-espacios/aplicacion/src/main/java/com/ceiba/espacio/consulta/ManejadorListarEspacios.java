package com.ceiba.espacio.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.espacio.puerto.dao.DaoEspacio;

@Component
public class ManejadorListarEspacios {

	private final DaoEspacio daoEspacio;

	public ManejadorListarEspacios(DaoEspacio daoEspacio) {
		this.daoEspacio = daoEspacio;
	}

	public List<DtoEspacio> ejecutar() {
		return this.daoEspacio.listar();
	}
}