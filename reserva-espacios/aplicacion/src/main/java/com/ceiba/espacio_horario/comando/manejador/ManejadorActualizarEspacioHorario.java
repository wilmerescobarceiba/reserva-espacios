package com.ceiba.espacio_horario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.espacio_horario.comando.ComandoEspacioHorario;
import com.ceiba.espacio_horario.comando.fabrica.FabricaEspacioHorario;
import com.ceiba.espacio_horario.modelo.entidad.EspacioHorario;
import com.ceiba.espacio_horario.servicio.ServicioActualizarEspacioHorario;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarEspacioHorario implements ManejadorComando<ComandoEspacioHorario> {

    private final FabricaEspacioHorario fabricaEspacioHorario;
    private final ServicioActualizarEspacioHorario servicioActualizarEspacioHorario;

    public ManejadorActualizarEspacioHorario(FabricaEspacioHorario fabricaEspacioHorario, ServicioActualizarEspacioHorario servicioActualizarEspacioHorario) {
        this.fabricaEspacioHorario = fabricaEspacioHorario;
        this.servicioActualizarEspacioHorario = servicioActualizarEspacioHorario;
    }

    public void ejecutar(ComandoEspacioHorario comandoEspacioHorario) {
        EspacioHorario espacioHorario = this.fabricaEspacioHorario.crear(comandoEspacioHorario);
        this.servicioActualizarEspacioHorario.ejecutar(espacioHorario);
    }
}
