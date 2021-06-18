package com.ceiba.aliado.servicio;

import com.ceiba.aliado.modelo.entidad.Aliado;
import com.ceiba.aliado.puerto.repositorio.RepositorioAliado;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearAliado {

    private static final String EL_ALIADO_YA_EXISTE_EN_EL_SISTEMA = "El aliado ya existe en el sistema";

    private final RepositorioAliado repositorioAliado;

    public ServicioCrearAliado(RepositorioAliado repositorioAliado) {
        this.repositorioAliado = repositorioAliado;
    }

    public Long ejecutar(Aliado aliado) {
        if(this.repositorioAliado.existe(aliado.getNombre())) {
            throw new ExcepcionDuplicidad(EL_ALIADO_YA_EXISTE_EN_EL_SISTEMA);
        }
        return this.repositorioAliado.crear(aliado);
    }
}
