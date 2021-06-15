package com.ceiba.categoria.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.categoria.servicio.ServicioEliminarCategoria;
import com.ceiba.manejador.ManejadorComando;


@Component
public class ManejadorEliminarCategoria implements ManejadorComando<Long> {

    private final ServicioEliminarCategoria servicioEliminarCategoria;

    public ManejadorEliminarCategoria(ServicioEliminarCategoria servicioEliminarCategoria) {
        this.servicioEliminarCategoria = servicioEliminarCategoria;
    }

    public void ejecutar(Long idcategoria) {
        this.servicioEliminarCategoria.ejecutar(idcategoria);
    }
}