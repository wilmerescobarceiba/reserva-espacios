package com.ceiba.espacio_horario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.espacio_horario.servicio.ServicioEliminarEspacioHorario;
import com.ceiba.manejador.ManejadorComando;


@Component
public class ManejadorEliminarEspacioHorario implements ManejadorComando<Long> {

    private final ServicioEliminarEspacioHorario servicioEliminarEspacioHorario;

    public ManejadorEliminarEspacioHorario(ServicioEliminarEspacioHorario servicioEliminarEspacioHorario) {
        this.servicioEliminarEspacioHorario = servicioEliminarEspacioHorario;
    }

    public void ejecutar(Long idespacioHorario) {
        this.servicioEliminarEspacioHorario.ejecutar(idespacioHorario);
    }
}