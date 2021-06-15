package com.ceiba.espacio.puerto.repositorio;

import com.ceiba.espacio.modelo.entidad.Espacio;

public interface RepositorioEspacio {
	/**
	 * Permite crear un espacio
	 * 
	 * @param espacio
	 * @return el id generado
	 */
	Long crear(Espacio espacio);

	/**
	 * Permite actualizar un espacio
	 * 
	 * @param usuario
	 */
	void actualizar(Espacio espacio);

	/**
	 * Permite eliminar un espacio
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un espacio con una nombre
	 * 
	 * @param nombre
	 * @return si existe o no
	 */
	boolean existe(String nombre);

	/**
	 * Permite validar si existe un espacio con un excluyendo un id
	 * 
	 * @param nombre
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String nombre);
	
}
