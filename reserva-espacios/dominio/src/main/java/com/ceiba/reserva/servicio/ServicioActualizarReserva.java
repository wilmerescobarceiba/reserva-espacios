package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioActualizarReserva {

    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

    private final RepositorioReserva repositorioReserva;

    public ServicioActualizarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Reserva reserva) {
        if(this.repositorioReserva.existe(reserva.getFecha(), reserva.getIdespacio(), reserva.getIdhorario())) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
        this.repositorioReserva.actualizar(reserva);
    }
}
