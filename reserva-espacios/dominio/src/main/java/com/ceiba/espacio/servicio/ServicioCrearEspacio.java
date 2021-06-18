package com.ceiba.espacio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;


public class ServicioCrearEspacio {

    private static final String EL_ESPACIO_YA_EXISTE_EN_EL_SISTEMA = "El espacio ya existe en el sistema";

    private final RepositorioEspacio repositorioEspacio;

    public ServicioCrearEspacio(RepositorioEspacio repositorioEspacio) {
        this.repositorioEspacio = repositorioEspacio;
    }

    public Long ejecutar(Espacio espacio) {
        if(this.repositorioEspacio.existe(espacio.getNombre())) {
            throw new ExcepcionDuplicidad(EL_ESPACIO_YA_EXISTE_EN_EL_SISTEMA);
        }
        return this.repositorioEspacio.crear(espacio);
    }

}
