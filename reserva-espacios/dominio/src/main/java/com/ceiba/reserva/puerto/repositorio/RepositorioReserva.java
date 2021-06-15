package com.ceiba.reserva.puerto.repositorio;

import java.util.Date;

import com.ceiba.reserva.modelo.entidad.Reserva;

public interface RepositorioReserva {
	/**
	 * Permite crear un reserva
	 * 
	 * @param reserva
	 * @return el id generado
	 */
	Long crear(Reserva reserva);

	/**
	 * Permite actualizar un reserva
	 * 
	 * @param usuario
	 */
	void actualizar(Reserva reserva);

	/**
	 * Permite eliminar un reserva
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un reserva con un excluyendo un id
	 * 
	 * @param nombre
	 * @return si existe o no
	 */
	boolean existe(Date fecha, Long idaliado, Long idespacio);

}
