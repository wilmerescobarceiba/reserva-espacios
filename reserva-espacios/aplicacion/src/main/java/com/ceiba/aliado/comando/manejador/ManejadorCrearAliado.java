package com.ceiba.aliado.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.aliado.comando.ComandoAliado;
import com.ceiba.aliado.comando.fabrica.FabricaAliado;
import com.ceiba.aliado.modelo.entidad.Aliado;
import com.ceiba.aliado.servicio.ServicioCrearAliado;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearAliado implements ManejadorComandoRespuesta<ComandoAliado, ComandoRespuesta<Long>> {

    private final FabricaAliado fabricaAliado;
    private final ServicioCrearAliado servicioCrearAliado;

    public ManejadorCrearAliado(FabricaAliado fabricaAliado, ServicioCrearAliado servicioCrearAliado) {
        this.fabricaAliado = fabricaAliado;
        this.servicioCrearAliado = servicioCrearAliado;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoAliado comandoAliado) {
        Aliado aliado = this.fabricaAliado.crear(comandoAliado);
        return new ComandoRespuesta<>(this.servicioCrearAliado.ejecutar(aliado));
    }
}