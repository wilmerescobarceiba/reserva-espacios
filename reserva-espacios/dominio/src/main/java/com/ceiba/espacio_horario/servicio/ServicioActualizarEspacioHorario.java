package com.ceiba.espacio_horario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio_horario.modelo.entidad.EspacioHorario;
import com.ceiba.espacio_horario.puerto.repositorio.RepositorioEspacioHorario;

public class ServicioActualizarEspacioHorario {

    private static final String LA_ESPACIO_HORARIO_YA_EXISTE_EN_EL_SISTEMA = "El espacioHorario ya existe en el sistema";

    private final RepositorioEspacioHorario repositorioEspacioHorario;

    public ServicioActualizarEspacioHorario(RepositorioEspacioHorario repositorioEspacioHorario) {
        this.repositorioEspacioHorario = repositorioEspacioHorario;
    }

    public void ejecutar(EspacioHorario espacioHorario) {
        validarExistenciaPrevia(espacioHorario);
        this.repositorioEspacioHorario.actualizar(espacioHorario);
    }

    private void validarExistenciaPrevia(EspacioHorario espacioHorario) {
        boolean existe = this.repositorioEspacioHorario.existe(espacioHorario.getIdhorario(),espacioHorario.getIdespacio());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_ESPACIO_HORARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
