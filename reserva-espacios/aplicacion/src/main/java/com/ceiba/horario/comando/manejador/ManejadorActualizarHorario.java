package com.ceiba.horario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.comando.fabrica.FabricaHorario;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.servicio.ServicioActualizarHorario;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarHorario implements ManejadorComando<ComandoHorario> {

    private final FabricaHorario fabricaHorario;
    private final ServicioActualizarHorario servicioActualizarHorario;

    public ManejadorActualizarHorario(FabricaHorario fabricaHorario, ServicioActualizarHorario servicioActualizarHorario) {
        this.fabricaHorario = fabricaHorario;
        this.servicioActualizarHorario = servicioActualizarHorario;
    }

    public void ejecutar(ComandoHorario comandoHorario) {
        Horario horario = this.fabricaHorario.crear(comandoHorario);
        this.servicioActualizarHorario.ejecutar(horario);
    }
}
