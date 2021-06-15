package com.ceiba.aliado.servicio;

import com.ceiba.aliado.puerto.repositorio.RepositorioAliado;

public class ServicioEliminarAliado {

    private final RepositorioAliado repositorioAliado;

    public ServicioEliminarAliado(RepositorioAliado repositorioAliado) {
        this.repositorioAliado = repositorioAliado;
    }

    public void ejecutar(Long id) {
        this.repositorioAliado.eliminar(id);
    }
}
