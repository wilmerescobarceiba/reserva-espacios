package com.ceiba.horario.servicio;

import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarHorario {

    private static final String LA_HORARIO_YA_EXISTE_EN_EL_SISTEMA = "El horario ya existe en el sistema";

    private final RepositorioHorario repositorioHorario;

    public ServicioActualizarHorario(RepositorioHorario repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

    public void ejecutar(Horario horario) {    	
        if(this.repositorioHorario.existeExcluyendoId(horario.getId(),horario.getHora())) {
            throw new ExcepcionDuplicidad(LA_HORARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
        this.repositorioHorario.actualizar(horario);
    }
}
