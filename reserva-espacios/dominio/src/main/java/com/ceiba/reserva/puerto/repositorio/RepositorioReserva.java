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
	 * @param reserva
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
	boolean existe(Date fecha, Long idespacio, Long idhorario);
	
	/**
	 * Permite calcular la cantidad de reservas hechas por un aliado en un día
	 * @param idaliado
	 * @return
	 */
	Long cantidadReservasDia(Long idaliado, Long idespacio, Date fecha);
	
	/**
	 * Se obtiene la cantidad de reservas realizadas por un aliado al mismo espacio en la misma semana
	 * 
	 * @param idespacio
	 * @param idaliado
	 * @param anioReserva
	 * @param semanaAnioReserva
	 * @return
	 */
	int obtenerReservasEnLaSemana(Long idespacio, Long idaliado, int anioReserva, int semanaAnioReserva, int dia);

	int obtenerHoraDelDia();

}
