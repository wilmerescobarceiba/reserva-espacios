package com.ceiba.categoria.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.categoria.comando.ComandoCategoria;
import com.ceiba.categoria.comando.fabrica.FabricaCategoria;
import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.categoria.servicio.ServicioActualizarCategoria;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarCategoria implements ManejadorComando<ComandoCategoria> {

    private final FabricaCategoria fabricaCategoria;
    private final ServicioActualizarCategoria servicioActualizarCategoria;

    public ManejadorActualizarCategoria(FabricaCategoria fabricaCategoria, ServicioActualizarCategoria servicioActualizarCategoria) {
        this.fabricaCategoria = fabricaCategoria;
        this.servicioActualizarCategoria = servicioActualizarCategoria;
    }

    public void ejecutar(ComandoCategoria comandoCategoria) {
        Categoria categoria = this.fabricaCategoria.crear(comandoCategoria);
        this.servicioActualizarCategoria.ejecutar(categoria);
    }
}
