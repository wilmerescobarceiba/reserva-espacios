package com.ceiba.horario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.comando.fabrica.FabricaHorario;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.servicio.ServicioCrearHorario;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearHorario implements ManejadorComandoRespuesta<ComandoHorario, ComandoRespuesta<Long>> {

    private final FabricaHorario fabricaHorario;
    private final ServicioCrearHorario servicioCrearHorario;

    public ManejadorCrearHorario(FabricaHorario fabricaHorario, ServicioCrearHorario servicioCrearHorario) {
        this.fabricaHorario = fabricaHorario;
        this.servicioCrearHorario = servicioCrearHorario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoHorario comandoHorario) {
        Horario horario = this.fabricaHorario.crear(comandoHorario);
        return new ComandoRespuesta<>(this.servicioCrearHorario.ejecutar(horario));
    }
}