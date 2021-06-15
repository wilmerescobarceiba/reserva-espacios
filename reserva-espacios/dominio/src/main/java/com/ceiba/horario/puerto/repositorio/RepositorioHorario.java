package com.ceiba.horario.puerto.repositorio;

import com.ceiba.horario.modelo.entidad.Horario;

public interface RepositorioHorario {

	/**
	 * Permite crear un horario
	 * 
	 * @param horario
	 * @return el id generado
	 */
	Long crear(Horario horario);

	/**
	 * Permite actualizar un horario
	 * 
	 * @param usuario
	 */
	void actualizar(Horario horario);

	/**
	 * Permite eliminar un horario
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un horario con una hora
	 * 
	 * @param hora
	 * @return si existe o no
	 */
	boolean existe(String hora);

	/**
	 * Permite validar si existe un horario con un excluyendo un id
	 * 
	 * @param hora
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String hora);

}
