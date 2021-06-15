package com.ceiba.espacio_horario.servicio;

import com.ceiba.espacio_horario.puerto.repositorio.RepositorioEspacioHorario;

public class ServicioEliminarEspacioHorario {

    private final RepositorioEspacioHorario repositorioEspacioHorario;

    public ServicioEliminarEspacioHorario(RepositorioEspacioHorario repositorioEspacioHorario) {
        this.repositorioEspacioHorario = repositorioEspacioHorario;
    }

    public void ejecutar(Long id) {
        this.repositorioEspacioHorario.eliminar(id);
    }
}
