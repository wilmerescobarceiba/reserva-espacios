package com.ceiba.aliado.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.aliado.comando.ComandoAliado;
import com.ceiba.aliado.comando.fabrica.FabricaAliado;
import com.ceiba.aliado.modelo.entidad.Aliado;
import com.ceiba.aliado.servicio.ServicioActualizarAliado;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarAliado implements ManejadorComando<ComandoAliado> {

    private final FabricaAliado fabricaAliado;
    private final ServicioActualizarAliado servicioActualizarAliado;

    public ManejadorActualizarAliado(FabricaAliado fabricaAliado, ServicioActualizarAliado servicioActualizarAliado) {
        this.fabricaAliado = fabricaAliado;
        this.servicioActualizarAliado = servicioActualizarAliado;
    }

    public void ejecutar(ComandoAliado comandoAliado) {
        Aliado aliado = this.fabricaAliado.crear(comandoAliado);
        this.servicioActualizarAliado.ejecutar(aliado);
    }
}
