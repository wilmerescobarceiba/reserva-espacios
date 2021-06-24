package com.ceiba.espacio_horario.puerto.repositorio;

import com.ceiba.espacio_horario.modelo.entidad.EspacioHorario;

public interface RepositorioEspacioHorario {
	/**
	 * Permite crear un espacioHorario
	 * 
	 * @param espacioHorario
	 * @return el id generado
	 */
	Long crear(EspacioHorario espacioHorario);

	/**
	 * Permite actualizar un espacioHorario
	 * 
	 * @param espacioHorario
	 */
	void actualizar(EspacioHorario espacioHorario);

	/**
	 * Permite eliminar un espacioHorario
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un espacioHorario con un nombre
	 *
	 * @param idhorario
	 * @param idespacio
	 * @return si existe o no
	 */
	boolean existe(Long idhorario, Long idespacio);
}
