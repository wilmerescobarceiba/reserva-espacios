package com.ceiba.reserva.servicio;

import java.util.Calendar;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
	private static final String CANTIDAD_MAXIMA_RESERVAS_SUPERADA = "Exedio la cantidad de reservas permitidas por día";
	private static final String RESERVA_HORARIO_NO_OFICINA = "Las reservas solo se pueden hacer en horario de oficina";
	private static final Long CANTIDAD_MAXIMA_RESERVAS_DIA = 5L;
	private static final Double PORCENTAJE_HORA_ADICIONAL = 0.05;
	private static final Double PORCENTAJE_DIA_ADICIONAL = 0.15;
	private static final int MAXIMO_DIAS_SIN_PORCENTAJE_ADICIONAL = 2;

	private static final int HORA_INICIO_DIA = 7; // 07:00 AM
	private static final int HORA_FIN_DIA = 12; // 12:00 M
	private static final int HORA_INICIO_TARDE = 13; // 01:00 PM
	private static final int HORA_FIN_TARDE = 17; // 05:00 PM
	private static final Double PORCENTAJE_ADICIONAL_FIN_DE_SEMANA = 0.2;

	private final RepositorioReserva repositorioReserva;
	private final RepositorioEspacio repositorioEspacio;

	public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioEspacio repositorioEspacio) {
		this.repositorioReserva = repositorioReserva;
		this.repositorioEspacio = repositorioEspacio;
	}

	public Long ejecutar(Reserva reserva) {
		validarReservaEnHorarioOficina();
		validarExistenciaPrevia(reserva);
		validarMaximo5hDia(reserva);
		reserva.setCostototal(calcularCostoTotal(reserva));
		return this.repositorioReserva.crear(reserva);
	}

	private void validarExistenciaPrevia(Reserva reserva) {
		if(this.repositorioReserva.existe(reserva.getFecha(), reserva.getIdespacio(),
				reserva.getIdhorario())){
			throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	/**
	 * Las reservas solo se hacen asi: Lunes - Viernes 07:00 AM - 12:00M y 01:00 PM
	 * - 05:00 PM
	 */
	private void validarReservaEnHorarioOficina() {
		int horaDelDia = this.repositorioReserva.obtenerHoraDelDia();

		if (horaDelDia < HORA_INICIO_DIA || (horaDelDia > HORA_FIN_DIA && horaDelDia < HORA_INICIO_TARDE)
				|| horaDelDia > HORA_FIN_TARDE) {
			throw new ExcepcionValorInvalido(RESERVA_HORARIO_NO_OFICINA);
		}
	}

	/**
	 * Valida quela cantidad de reservas no sea superior a 5 (por día)
	 * 
	 * @param reserva
	 */
	private void validarMaximo5hDia(Reserva reserva) {
		Long cantidad = this.repositorioReserva.cantidadReservasDia(reserva.getIdaliado(), reserva.getIdespacio(),
				reserva.getFecha());
		if (cantidad>=CANTIDAD_MAXIMA_RESERVAS_DIA) {
			throw new ExcepcionValorInvalido(CANTIDAD_MAXIMA_RESERVAS_SUPERADA);
		}
	}

	/**
	 * Si la cantidad de reservas en el día es >0 entonces al menos una reserva en
	 * el mismo día
	 * 
	 * @param reserva
	 * @return
	 */
	public Double calcularCostoTotal(Reserva reserva) {
		Double costoEspacio = this.repositorioEspacio.obtenerCostoPorId(reserva.getIdespacio());
		Long cantidadReservasDia = this.repositorioReserva.cantidadReservasDia(reserva.getIdaliado(),
				reserva.getIdespacio(), reserva.getFecha());

		Double total = (cantidadReservasDia > 0) ? costoEspacio + costoEspacio * PORCENTAJE_HORA_ADICIONAL
				: costoEspacio;
		
		return total + calcularCostoMayorA2DiasEnSemana(reserva, total) + calcularReservaFinDeSemana(reserva, total);
	}

	private Double calcularCostoMayorA2DiasEnSemana(Reserva reserva, Double total) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(reserva.getFecha());
		int semanaAnioReserva = calendar.get(Calendar.WEEK_OF_YEAR);
		int anioReserva = calendar.get(Calendar.YEAR);
		int dia = calendar.get(Calendar.DAY_OF_WEEK);

		int reservasEnLaSemana = this.repositorioReserva.obtenerReservasEnLaSemana(reserva.getIdespacio(),
				reserva.getIdaliado(), anioReserva, semanaAnioReserva, dia);
		if (reservasEnLaSemana > MAXIMO_DIAS_SIN_PORCENTAJE_ADICIONAL) {
			return total * PORCENTAJE_DIA_ADICIONAL;
		}
		return 0d;
	}

	private Double calcularReservaFinDeSemana(Reserva reserva, Double total) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(reserva.getFecha());
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return total * PORCENTAJE_ADICIONAL_FIN_DE_SEMANA;
		}
		return 0d;
	}
}
