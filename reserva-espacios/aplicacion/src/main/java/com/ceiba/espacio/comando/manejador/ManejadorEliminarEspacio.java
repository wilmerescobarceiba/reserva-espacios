package com.ceiba.espacio.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.espacio.servicio.ServicioEliminarEspacio;
import com.ceiba.manejador.ManejadorComando;


@Component
public class ManejadorEliminarEspacio implements ManejadorComando<Long> {

    private final ServicioEliminarEspacio servicioEliminarEspacio;

    public ManejadorEliminarEspacio(ServicioEliminarEspacio servicioEliminarEspacio) {
        this.servicioEliminarEspacio = servicioEliminarEspacio;
    }

    public void ejecutar(Long idEspacio) {
        this.servicioEliminarEspacio.ejecutar(idEspacio);
    }
}