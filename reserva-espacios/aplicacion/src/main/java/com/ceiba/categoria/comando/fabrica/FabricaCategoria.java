package com.ceiba.categoria.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.categoria.comando.ComandoCategoria;
import com.ceiba.categoria.modelo.entidad.Categoria;

@Component
public class FabricaCategoria {

    public Categoria crear(ComandoCategoria comandoCategoria) {
        return new Categoria(
        		comandoCategoria.getId(),
        		comandoCategoria.getCodigo(),
        		comandoCategoria.getNombre(),
        		comandoCategoria.getFotografia()
        );
    }

}
