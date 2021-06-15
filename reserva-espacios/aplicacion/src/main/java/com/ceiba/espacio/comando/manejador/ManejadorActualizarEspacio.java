package com.ceiba.espacio.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.comando.fabrica.FabricaEspacio;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.servicio.ServicioActualizarEspacio;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarEspacio implements ManejadorComando<ComandoEspacio> {

    private final FabricaEspacio fabricaEspacio;
    private final ServicioActualizarEspacio servicioActualizarEspacio;

    public ManejadorActualizarEspacio(FabricaEspacio fabricaEspacio, ServicioActualizarEspacio servicioActualizarEspacio) {
        this.fabricaEspacio = fabricaEspacio;
        this.servicioActualizarEspacio = servicioActualizarEspacio;
    }

    public void ejecutar(ComandoEspacio comandoEspacio) {
        Espacio espacio = this.fabricaEspacio.crear(comandoEspacio);
        this.servicioActualizarEspacio.ejecutar(espacio);
    }
}
