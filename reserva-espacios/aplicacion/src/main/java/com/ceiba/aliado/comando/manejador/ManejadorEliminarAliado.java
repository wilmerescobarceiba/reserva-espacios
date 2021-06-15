package com.ceiba.aliado.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.aliado.servicio.ServicioEliminarAliado;
import com.ceiba.manejador.ManejadorComando;


@Component
public class ManejadorEliminarAliado implements ManejadorComando<Long> {

    private final ServicioEliminarAliado servicioEliminarAliado;

    public ManejadorEliminarAliado(ServicioEliminarAliado servicioEliminarAliado) {
        this.servicioEliminarAliado = servicioEliminarAliado;
    }

    public void ejecutar(Long idAliado) {
        this.servicioEliminarAliado.ejecutar(idAliado);
    }
}