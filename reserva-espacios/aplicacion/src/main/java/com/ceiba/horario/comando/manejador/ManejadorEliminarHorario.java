package com.ceiba.horario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.horario.servicio.ServicioEliminarHorario;
import com.ceiba.manejador.ManejadorComando;


@Component
public class ManejadorEliminarHorario implements ManejadorComando<Long> {

    private final ServicioEliminarHorario servicioEliminarHorario;

    public ManejadorEliminarHorario(ServicioEliminarHorario servicioEliminarHorario) {
        this.servicioEliminarHorario = servicioEliminarHorario;
    }

    public void ejecutar(Long idHorario) {
        this.servicioEliminarHorario.ejecutar(idHorario);
    }
}