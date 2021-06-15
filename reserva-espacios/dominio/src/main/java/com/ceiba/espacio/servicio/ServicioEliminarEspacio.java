package com.ceiba.espacio.servicio;

import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;

public class ServicioEliminarEspacio {

    private final RepositorioEspacio repositorioEspacio;

    public ServicioEliminarEspacio(RepositorioEspacio repositorioEspacio) {
        this.repositorioEspacio = repositorioEspacio;
    }

    public void ejecutar(Long id) {
        this.repositorioEspacio.eliminar(id);
    }
}
