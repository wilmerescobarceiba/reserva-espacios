package com.ceiba.categoria.puerto.repositorio;

import com.ceiba.categoria.modelo.entidad.Categoria;

public interface RepositorioCategoria {
	/**
	 * Permite crear un categoria
	 * 
	 * @param categoria
	 * @return el id generado
	 */
	Long crear(Categoria categoria);

	/**
	 * Permite actualizar un categoria
	 * 
	 * @param categoria
	 */
	void actualizar(Categoria categoria);

	/**
	 * Permite eliminar un categoria
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un categoria con un nombre
	 * 
	 * @param nombre
	 * @return si existe o no
	 */
	boolean existe(String nombre);

	/**
	 * Permite validar si existe un categoria con un excluyendo un id
	 * 
	 * @param nombre
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String nombre);

}
