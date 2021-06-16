package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private static final String EL_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
	private static final String CANTIDAD_MAXIMA_RESERVAS_SUPERADA = "Exedio la cantidad de reservas permitidas por día";
	private static final Long CANTIDAD_MAXIMA_RESERVAS_DIA = 5L;

	private final RepositorioReserva repositorioReserva;

	public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
		this.repositorioReserva = repositorioReserva;
	}

	public Long ejecutar(Reserva reserva) {
		validarExistenciaPrevia(reserva);
		validarMaximo5hDia(reserva);
		return this.repositorioReserva.crear(reserva);
	}

	private void validarExistenciaPrevia(Reserva reserva) {
		boolean existe = this.repositorioReserva.existe(reserva.getFecha(),
				reserva.getIdespacio(), reserva.getIdhorario());
		if (existe) {
			throw new ExcepcionDuplicidad(EL_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private void validarMaximo5hDia(Reserva reserva) {
		Long cantidad = this.repositorioReserva.cantidadReservasDia(reserva.getIdaliado(), reserva.getIdespacio(), reserva.getFecha());
		if (cantidad.equals(CANTIDAD_MAXIMA_RESERVAS_DIA)) {
			throw new ExcepcionValorInvalido(CANTIDAD_MAXIMA_RESERVAS_SUPERADA);
		}
	}

	private Reserva calcularCosto(Reserva reserva) {
		return reserva;
	}

	private void validarReservaEnHorarioOficina() {
	}

}
