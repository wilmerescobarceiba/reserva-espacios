package com.ceiba.espacio.servicio;

import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarEspacio {

    private static final String LA_ESPACIO_YA_EXISTE_EN_EL_SISTEMA = "El espacio ya existe en el sistema";

    private final RepositorioEspacio repositorioEspacio;

    public ServicioActualizarEspacio(RepositorioEspacio repositorioEspacio) {
        this.repositorioEspacio = repositorioEspacio;
    }

    public void ejecutar(Espacio espacio) {
        validarExistenciaPrevia(espacio);
        this.repositorioEspacio.actualizar(espacio);
    }

    private void validarExistenciaPrevia(Espacio espacio) {
        boolean existe = this.repositorioEspacio.existeExcluyendoId(espacio.getId(),espacio.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_ESPACIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
